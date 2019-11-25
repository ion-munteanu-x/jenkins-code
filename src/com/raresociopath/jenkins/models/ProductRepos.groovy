package com.raresociopath.jenkins.models

import com.raresociopath.jenkins.jobs.ConstantsData
import com.raresociopath.jenkins.jobs.JobsData

class ProductRepos {
    private Cnst = new ConstantsData()
    private Jobs = new JobsData()
    private Map defaults = ['namespace': 'raresociopath', library: false]

    private Map scalaLib = defaults + [language: 'scala', library: true]

    public def JenkinsJobs = new ProductRepository(defaults + [
            id       : 'jenkins-jobs',
            humanName: 'JenkinsJobs',
            namespace: 'code-factory-group'
    ])
    
    ProductRepository getByParam(param) {
        dataByParam.get(param)
    }

    ProductRepository call(id) {
        dataById.get(id)
    }
}
