import static com.raresociopath.jenkins.common.data.StaticConstants.Jobs

folder(Jobs.InternalJobsFolder) {
    displayName('Internal')
    description('This folder contains internal jobs, used either by another jobs or by administrator.')
}