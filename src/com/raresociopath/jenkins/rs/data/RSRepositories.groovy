package com.raresociopath.jenkins.rs.data

import com.raresociopath.jenkins.rs.models.RSRepository

class RSRepositories {
    private Cnst = new RSConstants()
    private Jobs = new RSJobs()
    private Map defaults = ['namespace': 'raresociopath', 'defaultBranch': Cnst.DefaultBranch]

    public def JenkinsJobs = new RSRepository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
}