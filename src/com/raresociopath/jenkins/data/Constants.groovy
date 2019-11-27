package com.raresociopath.jenkins.data

class Constants {

    // Docker configuration.
    public String DockerRegistry = "registry.hub.docker.com/raresociopath"
    public String DockerRegistryJenkinsCredentialsId = "rs-docker-hub"

    // Default branch of all the repos in case it was not specified.
    public String DefaultBranch = "master"

    // Git Group
    public String SCM_GROUP = "raresociopath"
}