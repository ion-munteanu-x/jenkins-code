String call(String repo) {

//    checkParam(env.SCM_CLONE_METHOD, 'Please set the SCM_CLONE_METHOD build parameter!')
    checkParam(env.SCM_SERVER, 'Please set the SCM_SERVER build parameter!')
    checkParam(env.SCM_CLONE_METHOD, 'Please set the SCM_CLONE_METHOD build parameter!')

    String cloneMethod = env.SCM_CLONE_METHOD.toLowerCase()
    if (!(cloneMethod == 'ssh' || cloneMethod == 'https')) {
        cloneMethod = 'ssh'
    }

//    info(ProductRepository.reposMapByName)

    if (cloneMethod == 'ssh') {
        "git@${env.SCM_SERVER}:code-factory-group/${repo}.git".toString()
    } else {
        "https://${env.SCM_SERVER}/code-factory-group/${repo}.git".toString()
    }
}