#!groovy

String call(line) {
    def current = ""
    if (currentBuild.description != null) current = currentBuild.description + "<br>"
    currentBuild.description = current + line
}