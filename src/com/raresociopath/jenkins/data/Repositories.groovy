package com.raresociopath.jenkins.data

import com.raresociopath.jenkins.models.Repository

class Repositories {
    private Const = new Constants()
    private Jobs = new Jobs()
    private Map defaults = ['namespace': 'raresociopath', 'defaultBranch': Const.DefaultBranch]
    private Map simpleProject = defaults + [language: 'simple']

    public def JenkinsJobs = new Repository(defaults + [
            id       : 'rs-pipelines',
            humanName: 'JenkinsJobs',
    ])
    public def HelloWorldProject = new Repository(simpleProject + [
            id       : 'rs-hello-world',
            humanName: 'Hello World App',
            distJobId: "$Jobs.BuildSimpleProjectsFolder/build-hello-world"
    ])
    public def HelloHellProject = new Repository(simpleProject + [
            id       : 'rs-hello-hell',
            humanName: 'Hello Hell',
            distJobId: "$Jobs.BuildSimpleProjectsFolder/build-hello-hell"
    ])        

    public List<Repositories> AllProjects = [
            HelloWorldProject,HelloHellProject
    ]    
}