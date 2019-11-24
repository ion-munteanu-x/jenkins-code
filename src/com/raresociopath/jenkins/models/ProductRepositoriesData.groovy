package com.raresociopath.jenkins.models

import com.raresociopath.jenkins.jobs.JobsData

class ProductRepositoriesData {
    private def Jobs = new JobsData()

    public def JenkinsJobs = new ProductRepository('JenkinsJobs', 'rs-jenkins-jobs', System.getenv('GLOBAL_DSL_DEFAULT_VERSION') ?: 'master')
}