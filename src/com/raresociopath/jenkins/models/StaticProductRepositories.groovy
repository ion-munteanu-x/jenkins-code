package com.raresociopath.jenkins.models

class StaticProductRepositories {
    private static def underlying = new ProductRepositoriesData()
    public static def JenkinsJobs = underlying.JenkinsJobs
}