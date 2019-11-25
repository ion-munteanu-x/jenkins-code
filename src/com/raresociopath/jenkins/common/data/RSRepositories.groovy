package com.williamhill.jenkins.common.data

import com.williamhill.jenkins.common.data.RSConstants
import com.williamhill.jenkins.common.data.RSJobs
import com.williamhill.jenkins.common.models.RSRepository


class RSRepositories {
    private RSConstants Cnst = new RSConstants()
    private RSJobs Jobs = new RSJobs()
    private Map defaults = ['namespace': 'raresociopath', library: false]

    public def RSRepository JenkinsJobs = new RSRepository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
}