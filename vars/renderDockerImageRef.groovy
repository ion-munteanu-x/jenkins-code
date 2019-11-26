#!groovy

String call(appName, version) {
    checkParam(env.DOCKER_REGISTRY_NAME, 'Please set the DOCKER_REGISTRY_NAME build parameter!')

    def repoName = env.DOCKER_REGISTRY_NAME

    def targetImageName = "$repoName/$appName".toString()
    def targetImageRef = "$targetImageName:$version".toString()

    targetImageRef
}