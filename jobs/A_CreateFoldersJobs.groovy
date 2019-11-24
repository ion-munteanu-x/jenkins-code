import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs

folder(Jobs.InternalJobsFolder) {
    displayName('Internal')
    description('This folder contains internal jobs, used either by another jobs or by administrator.')
}

folder(Jobs.BuildJobsFolder) {
    displayName('Build')
    description('This folder contains build jobs.')
}

folder(Jobs.TestsJobsFolder) {
    displayName('Tests')
    description('This folder contains tests jobs.')
}

folder(Jobs.DeployJobsFolder) {
    displayName('Deploy')
    description('This folder contains deploy jobs.')
}