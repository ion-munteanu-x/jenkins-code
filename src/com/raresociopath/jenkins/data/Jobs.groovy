package com.raresociopath.jenkins.data

class Jobs {

    //folders
    public String InternalJobsFolder = "internal"
    public String BuildJobsFolder = "build"
    public String BuildRawJobsFolder = "$BuildJobsFolder/build-raw-folder"

    //jobs

    //internal
    public String SeedCustom = "$InternalJobsFolder/seed-custom"

    //build
    public String BuildRawProject = "$BuildRawJobsFolder/build-raw"

}