package com.raresociopath.jenkins.jobs

class JobsData {

    public String InternalJobsFolder = "internal"
    public String BuildJobsFolder = "build"
    public String TestsJobsFolder = "tests"
    public String DeployJobsFolder = "deploy"

    public String SeedCustom = "$InternalJobsFolder/seed-custom"

    public String BuildHelloWorld = "$BuildJobsFolder/build-hello-world"
}