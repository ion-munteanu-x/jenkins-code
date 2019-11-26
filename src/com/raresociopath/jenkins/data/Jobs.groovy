package com.raresociopath.jenkins.data

class Jobs {

    //folders
    public String InternalJobsFolder = "internal"
    public String BuildJobsFolder = "build"
    public String BuildSimpleProjectsFolder = "$BuildJobsFolder/build-simple-projects-folder"

    //jobs

    //internal
    public String SeedCustom = "$InternalJobsFolder/seed-custom"

    //build
    public String BuildSimpleProject = "$BuildSimpleProjectsFolder/build-simple"

}