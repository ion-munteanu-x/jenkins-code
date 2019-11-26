package com.raresociopath.jenkins.data

class Jobs {

    //folders
    public String InternalJobsFolder = "internal"
    public String BuildJobsFolder = "build"

    //jobs

    //internal
    public String SeedCustom = "$InternalJobsFolder/seed-custom"

    //build
    public String BuildRawProject = "$BuildJobsFolder/build-raw"

}