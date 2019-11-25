package com.raresociopath.jenkins.common.models

class RSRepository {
    String humanName
    String safeHumanName
    String shortRepoParam
    String namespace
    String id
    String name
    String defaultBranch
    String language

    RSRepository(Map<String, Object> data) {
        this.id = data.id
        this.humanName = data.humanName ?: data.id.capitalize()
        this.name = data.repoName ?: data.id
        this.defaultBranch = data.defaultBranch ?: 'develop'
        this.language = data.language
        this.namespace = data.namespace
        this.safeHumanName = humanName.replaceAll('[ -]', "_")
        this.library = data.library?.toBoolean() ?: false
        this.shortRepoParam = "${this.safeHumanName}_Version"
    }

    boolean isSbt() {
        language == "scala" && !library
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

    boolean isIstioMixerAdapter() {
        language == "istio-adapter"
    }

    String cloneUrl(ssh, server) {
        if (ssh) "git@$server:${namespace}/${name}.git".toString()
        else "https://$server/${namespace}/${name}.git".toString()
    }

    def getBuiltVersionFrom(Map data) {
        getFrom(data).builtVersion
    }

    def getVersionFromEnv(env) {
        env.getEnvironment().get(shortRepoParam)
    }

    def getFrom(Map<String, Object> data) {
        def result = data.get(id)
        if (result == null) {
            throw new RuntimeException("input map doesn't contain key $id")
        }
        result
    }
}