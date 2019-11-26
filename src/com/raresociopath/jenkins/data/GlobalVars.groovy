package com.raresociopath.jenkins.data

class GlobalVars {

    static void putDockerRegistry(delegate) {
        delegate.env("DOCKER_REGISTRY_NAME", "$StaticData.Constants.DockerRegistry")
    }

    static void putDockerCredentialsId(delegate) {
        delegate.env('DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID', "$StaticData.Constants.DockerRegistryJenkinsCredentialsId")
    }

    static void putHere(delegate) {
        putDockerRegistry(delegate)
        putDockerCredentialsId(delegate)
    }
}
