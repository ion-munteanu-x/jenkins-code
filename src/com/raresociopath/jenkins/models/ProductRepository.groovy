package com.raresociopath.jenkins.models

import com.raresociopath.jenkins.jobs.ConstantsData
import com.raresociopath.jenkins.jobs.dsl.Cloning

import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs

class ProductRepository {
    private def Constants = new ConstantsData()
    String humanName
    String group
    String id
    String name
    String defaultBranch = 'develop'
    boolean deployable = true
    boolean canBeDisabled = false
    boolean library = false
    String language
    String distributeJobName
    boolean requiresAvro = false

    /**
     * Path inside a gitlab server
     * @return
     */
    String repoPath() { return ("$group/$name").toString() }

    String id() { return ("${group}___$name").toString() }

    String jobId() { return ("${group}-$name").toString() }

    String REPO_ENV_NAME() { return Constants.RepoEnvNamePrefix + id() }

    String REPO_PARAM() { return Constants.RepoEnvNamePrefix + id() }

    String shortRepoParam() { return safeHumanName() + Constants.RepoEnvNameSuffix }

    ProductRepository(humanName, name, defaultBranch = null, group = null) {
        this.humanName = humanName
        this.group = group ?: Constants.GITHUB_SCM_GROUP
        this.name = name
        if (defaultBranch) {
            this.defaultBranch = defaultBranch
        }
    }

    ProductRepository(Map<String, Object> data) {
        this.id = data.id
        this.humanName = data.humanName
        this.name = data.repoName ?: data.id
        this.deployable = data.deployable ?: true
        this.requiresAvro = data.requiresAvro ?: false
        this.defaultBranch = data.defaultBranch ?: 'develop'
        this.language = data.language
        this.group = data.namespace
    }

    String sshCloneUrl(String server) {
        "git@$server:${repoPath()}.git".toString()
    }

    String httpCloneUrl(String server) {
        "https://$server/${repoPath()}.git".toString()
    }

    String cloneUrl(boolean shouldBeSSH, String server) {
        shouldBeSSH ? sshCloneUrl(server) : httpCloneUrl(server)
    }

    String cloneUrl(Cloning cloner) {
        cloner.cloneUrl(this)
    }

    String safeHumanName() { return humanName.replaceAll('[ -]', "_") }

    ProductRepository notDeployable() {
        deployable = false
        this
    }

    ProductRepository canBeDisabledInDeployment() {
        canBeDisabled = true
        this
    }

    ProductRepository asJavaProject() {
        language = "java"
        distributeJobName = Jobs.BuildGradleDockerImage
        this
    }

    ProductRepository asScalaProject() {
        language = "scala"
        distributeJobName = Jobs.BuildSbtDockerImage
        this
    }

    ProductRepository asLibrary() {
        library = true
        this
    }

    ProductRepository asScalaLib() {
        this.asScalaProject().withDistJob(Jobs.PublishScalaProject).notDeployable().asLibrary()
    }

    ProductRepository asRawDockerProject() {
        language = "raw-docker"
        distributeJobName = Jobs.BuildRawDockerImage
        this
    }

    ProductRepository asNodeProject() {
        language = "node"
        distributeJobName = Jobs.BuildNodeDockerImage
        this
    }

    ProductRepository asIstioMixerAdapter() {
        language = "istio-adapter"
        distributeJobName = Jobs.BuildDockerIstioMixerAdapter
        this
    }

    ProductRepository withDistJob(String jobId) {
        distributeJobName = jobId
        this
    }

    ProductRepository withRequiresAvro() {
        this.requiresAvro = true
        this
    }

    boolean isDistributable() {
        distributeJobName != null
    }

    boolean isScala() {
        language == "scala"
    }

    boolean isJava() {
        language == "java"
    }

    boolean isNode() {
        language == "node"
    }

    boolean isRawDocker() {
        language == "raw-docker"
    }
}