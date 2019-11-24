#!groovy

String call(url, reference, credentials, depth = 6) {
    info("Checking out revision $reference of $url")
    def depthSet = depth ?: 0

    def gitCloneExt = [$class: 'CloneOption', noTags: false, shallow: false]

    def retries = 10
    while (retries > 0) {
        try {
            gitCloneExt.shallow = depthSet > 0
            depthSet > 1 ? gitCloneExt.depth = depthSet : gitCloneExt.remove('depth')
            checkout([
                    $class           : 'GitSCM',
                    branches         : [[name: reference]],
                    userRemoteConfigs: [[credentialsId: credentials, url: url]],
                    extensions       : [gitCloneExt]
            ])
            return true
        } catch (Throwable e) {
            debug("Git clone error is ${e.toString()}")
            if (retries > 0) {
                if (depthSet > 0 && e.getMessage() == "Couldn't find any revision to build. Verify the repository and branch configuration for this job.") {
                    info("Disabling shallow clone for checking out $reference of $url because it looks like full repo has to be cloned to resolve.")
                    sh "rm -rf .git" // to force clone
                    depthSet = 0
                }
                retries = retries - 1
                sleep time: 2, unit: 'SECONDS'
            } else throw e
        }
    }
}
