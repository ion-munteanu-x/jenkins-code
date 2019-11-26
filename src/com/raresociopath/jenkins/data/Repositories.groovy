package com.raresociopath.jenkins.data

import com.raresociopath.jenkins.models.Repository

class Repositories {
    private Const = new Constants()
    private Jobs = new Jobs()
    private Map defaults = ['namespace': 'raresociopath', 'defaultBranch': Const.DefaultBranch]
    private Map rawDocker = defaults + [language: 'raw']

    public def JenkinsJobs = new Repository(defaults + [
            id       : 'rs-jenkins-jobs',
            humanName: 'JenkinsJobs',
    ])
    public def HelloWorldProject = new Repository(rawDocker + [
            id       : 'rs-hello-world',
            humanName: 'HelloWorld',
            distJobId: "$Jobs.BuildRawJobsFolder/build-hello-world"
    ])    

    public List<Repositories> AllProjects = [
            HelloWorldProject
    ]    
}