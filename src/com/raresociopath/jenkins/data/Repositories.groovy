package com.raresociopath.jenkins.data

import com.raresociopath.jenkins.models.Repository

class Repositories {
    private Const = new Constants()
    private Jobs = new Jobs()
    private Map defaults = ['namespace': 'raresociopath', 'defaultBranch': Const.DefaultBranch]
    private Map simpleProject = defaults + [language: 'simple']

    public def JenkinsJobs = new Repository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
    public def HelloWorldProject = new Repository(simpleProject + [
            id       : 'rs-hello-world',
            humanName: 'Hello World App',
            distJobId: "$Jobs.BuildSimpleProjectsFolder/build-hello-world"
    ])
    public def HelloWorldProject2 = new Repository(simpleProject + [
            id       : 'rs-hello-world-2',
            humanName: 'HelloWorld2',
            distJobId: "$Jobs.BuildSimpleProjectsFolder/build-hello-world-2"
    ])        

    public List<Repositories> AllProjects = [
            HelloWorldProject,HelloWorldProject2
    ]    
}