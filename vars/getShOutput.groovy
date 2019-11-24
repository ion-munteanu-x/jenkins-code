#!groovy

String call(String command, boolean liveOutput = false) {

    // ensure that all mandatory config parameters are set
    checkParam(command, 'The shell \'command\' must be set to get the output of its execution.')

    if (liveOutput) {
        String tmpFile = "._jenkinstmp_tmpSbtOutput_build_${env.BUILD_NUMBER}_timestamp_${System.currentTimeMillis()}_tid_${Thread.currentThread().getId()}"
        sh "$command | tee ${tmpFile}"
        def result = readFile tmpFile
        return result?.trim()
    } else {
        return sh(returnStdout: true, script: "#!/bin/sh -e\n$command").trim()
    }
}