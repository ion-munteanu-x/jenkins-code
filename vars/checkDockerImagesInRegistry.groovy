def call(dockerProps, images) {

    if (images instanceof String) {
        images = [images]
    }

    Map<String, Boolean> resp = [:]

    docker.withRegistry(dockerProps.dockerRepoUrl, dockerProps.repoCredentialsId) {
        resp = images.collectEntries { image ->
            try {
                docker.image(image).pull()
                info("Image $image exists in repository")
                [image, true]
            } catch (exc) {
                info("Image doesn't exist in repo")
                [image, false]
            }
        }
    }
    debug("checkDockerImagesInRegistry result: ${resp.collect { "${it.key}: ${it.value}" }.join(", ")}")
    return resp
}