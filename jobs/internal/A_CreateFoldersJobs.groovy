import static com.raresociopath.jenkins.data.Constants

folder(Constants.InternalJobsFolder) {
    displayName('Internal')
    description('This folder contains internal jobs, used either by another jobs or by administrator.')
}