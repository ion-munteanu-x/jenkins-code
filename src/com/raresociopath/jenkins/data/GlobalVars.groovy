package com.williamhill.jenkins.data

class GlobalVars {

    private Constants = new Constants()

    static void putDockerRegistry(delegate) {
        delegate.env("DOCKER_REGISTRY_NAME", "$Constants.DockerRegistry")
    }

    static void putDockerCredentialsId(delegate) {
        delegate.env('DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID', "$Constants.DockerRegistryJenkinsCredentialsId")
    }

    static void putHere(delegate) {
        putDockerRegistry(delegate)
        putDockerCredentialsId(delegate)
    }
}
