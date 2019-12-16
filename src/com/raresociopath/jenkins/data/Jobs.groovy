package com.raresociopath.jenkins.data

class Jobs {

    //folders
    public String InternalJobsFolder = "internal"
    public String BuildJobsFolder = "build"
    public String TestJobsFolder = "test"
    public String BuildSimpleProjectsFolder = "$BuildJobsFolder/build-simple-projects-folder"

    //jobs
    public String ApproveSignaturesJobName = "$InternalJobsFolder/approve-signatures"

    //internal
    public String SeedCustom = "$InternalJobsFolder/seed-custom"

    //build
    public String BuildSimpleProject = "$BuildSimpleProjectsFolder/build-simple"

    //test
    public String TestJob = "$TestJobsFolder/test"

}