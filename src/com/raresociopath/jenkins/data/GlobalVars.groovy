package com.raresociopath.jenkins.data

class GlobalVars {

    private Const = new Constants()

    static void putDockerRegistry(delegate) {
        delegate.env("DOCKER_REGISTRY_NAME", "$Const.DockerRegistry")
    }

    static void putDockerCredentialsId(delegate) {
        delegate.env('DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID', "$Const.DockerRegistryJenkinsCredentialsId")
    }

    static void putHere(delegate) {
        putDockerRegistry(delegate)
        putDockerCredentialsId(delegate)
    }
}
