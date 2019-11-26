#!groovy

/**
 * Gets the commit hash of the current project.
 *
 * More info:
 *  - http://stackoverflow.com/questions/35554983/git-variables-in-jenkins-workflow-plugin
 *
 * @return git commit hash
 *
 * Example call:
 *
 * String commit = getGitCommit()
 */
String call() {

  getShOutput('git rev-parse HEAD')
}