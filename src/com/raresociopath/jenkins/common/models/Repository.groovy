package com.raresociopath.jenkins.common.models

import com.raresociopath.jenkins.common.data.ConstantsData
import com.raresociopath.jenkins.common.util.Cloning

class Repository {
    private def Constants = new ConstantsData()
    String humanName
    String group
    String id
    String name
    String defaultBranch = Constants.DefaultBranch
    String language

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

    Repository(humanName, name, defaultBranch = null, group = null) {
        this.humanName = humanName
        this.group = group ?: Constants.GITHUB_SCM_GROUP
        this.name = name
        if (defaultBranch) {
            this.defaultBranch = defaultBranch
        }
    }

    Repository(Map<String, Object> data) {
        this.id = data.id
        this.humanName = data.humanName
        this.name = data.repoName ?: data.id
        this.defaultBranch = data.defaultBranch ?: 'master'
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
}