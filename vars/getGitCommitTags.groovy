#!groovy

List<String> call() {
    commitTags = []
    String allCommitTagsCommand = "git tag --points-at HEAD"
    commitTags = getShOutput(allCommitTagsCommand).split()
    commitTags
}