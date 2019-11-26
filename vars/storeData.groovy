import com.raresociopath.jenkins.helpers.MapsDeepMerge

void call(Map<String, Object> data = [:], Boolean joinToCurrentFile = true) {
    def deepMerge = new MapsDeepMerge()
    def artifactName = "build-return.json"

    def doWork = {
        Map<String, Object> allData = [:]

        if (joinToCurrentFile && fileExists(artifactName)) {
            allData.putAll(loadJsonFile(artifactName))
        }

        def buildInfo = [build: [
                url   : env.BUILD_URL.take(env.BUILD_URL.length() - 1),
                number: env.BUILD_NUMBER,
        ]]

        allData = deepMerge.merge(allData, buildInfo, data)

        writeFile file: artifactName, text: toPrettyJson(allData)
        archiveArtifacts artifacts: artifactName
    }

    if (pwd() != env.WORKSPACE) {
        dir(env.WORKSPACE) {
            doWork()
        }
    } else {
        doWork()
    }
}