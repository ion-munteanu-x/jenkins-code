package com.raresociopath.jenkins.common.data

import com.rarespciopath.jenkins.common.models.RSRepository


class RSRepositories {
    private Cnst = new RSConstants()
    private Jobs = new RSJobs()
    private Map defaults = ['namespace': 'raresociopath', library: false]

    public def JenkinsJobs = new RSRepository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
}