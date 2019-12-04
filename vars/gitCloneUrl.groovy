import com.raresociopath.jenkins.models.Repository

String call(String repo) {

//    checkParam(env.SCM_CLONE_METHOD, 'Please set the SCM_CLONE_METHOD build parameter!')
    checkParam(env.SCM_SERVER, 'Please set the SCM_SERVER build parameter!')
    checkParam(env.SCM_CLONE_METHOD, 'Please set the SCM_CLONE_METHOD build parameter!')

    String cloneMethod = env.SCM_CLONE_METHOD.toLowerCase()
    if (!(cloneMethod == 'ssh' || cloneMethod == 'https')) {
        cloneMethod = 'ssh'
    }
    String server = env.SCM_SERVER
    if(server == null){
        server = "github.com"
    }
    if (repo instanceof Repository) {
        repo.cloneUrl(cloneMethod == 'ssh', server)
    } else {
        if (cloneMethod == 'ssh') {
            "git@${env.SCM_SERVER}:raresociopath/${repo}.git".toString()
        } else {
            "https://${env.SCM_SERVER}/raresociopath/${repo}.git".toString()
        }
    }
}