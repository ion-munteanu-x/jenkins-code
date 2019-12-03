#!groovy

Map call() {
    Map result = [:]
    result.branch = getGitBranch()
    result.commit = getGitCommit()
    result.commitTags = getGitCommitTags()
    result.commitRef = result.commit.take(8)
    result.isDetachedHead = isDetachedHead()
    result.normalizedBranch = result.branch.replaceAll("[_ /\\&]", "-")
    result
}
