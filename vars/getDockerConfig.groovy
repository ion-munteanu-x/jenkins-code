#!groovy

Map call(Boolean hardCheck = false) {
    if (hardCheck) {
        checkParam(env.DOCKER_REGISTRY_NAME, 'Please set the DOCKER_REGISTRY_NAME build parameter!')
        checkParam(env.DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID, 'Please set the DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID build parameter!')
    } else if (!env.DOCKER_REGISTRY_NAME?.trim()) {
        return [:]
    }

    def repoName = env.DOCKER_REGISTRY_NAME
    def repoUrl = "https://$repoName".toString()

    Map result = [:]
    result.dockerRepoName = repoName
    result.dockerRepoUrl = repoUrl
    result.repoCredentialsId = env.DOCKER_REGISTRY_JENKINS_CREDENTIALS_ID

    result
}