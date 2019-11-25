package com.raresociopath.jenkins.data

import com.raresociopath.jenkins.models.Repository

class Repositories {
    private Const = new Constants()
    private Map defaults = ['namespace': 'raresociopath', 'defaultBranch': Const.DefaultBranch]

    public def JenkinsJobs = new Repository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
}