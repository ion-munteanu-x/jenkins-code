import static com.raresociopath.jenkins.data.StaticData.Jobs

folder(Jobs.InternalJobsFolder) {
    displayName('Internal')
    description('This folder contains internal jobs, used either by another jobs or by administrator.')
}

folder(Jobs.BuildJobsFolder) {
    displayName('Build')
    description('This folder contains build jobs.')
}

folder(Jobs.BuildSimpleProjectsFolder) {
    displayName('Build Simple Projects')
    description('This folder contains build jobs for projects that have Dockerfile at the root of the repository.')
}