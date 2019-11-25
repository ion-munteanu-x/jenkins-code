package com.raresociopath.jenkins.common.data

import com.raresociopath.jenkins.common.models.RSRepository


class RSRepositories {
    private Cnst = new RSConstants()
    private Jobs = new RSJobs()
    private Map defaults = ['namespace': 'raresociopath']

    public def JenkinsJobs = new RSRepository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
}