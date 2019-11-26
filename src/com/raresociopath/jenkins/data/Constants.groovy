package com.raresociopath.jenkins.data

class Constants {

    public String DockerRegistry = "docker.io"
    public String DockerRegistryJenkinsCredentialsId = ""

    public String RepoEnvNamePrefix = "REPO_TAG____"
    public String RepoEnvNameSuffix = "_Version"

    public String DefaultBranch = "master"

    public String SCM_GROUP = "raresociopath"

    public String InternalJobsFolder = "internal"
    public String SeedCustom = "$InternalJobsFolder/seed-custom"
}