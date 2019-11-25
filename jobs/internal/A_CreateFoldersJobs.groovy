import static com.raresociopath.jenkins.common.data.RSJobs

folder(RSJobs.InternalJobsFolder) {
    displayName('Internal')
    description('This folder contains internal jobs, used either by another jobs or by administrator.')
}