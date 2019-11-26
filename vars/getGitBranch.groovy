#!groovy

/**
 * Gets the branch name of the current project.
 *
 * When Jenkins checks out git projects it does not check out branches, instead it checks out the last commit of the
 * branch it is configured to use for the build. This leads to the situations that all git repos in Jenkins are actually
 * in a detached HEAD state. Also Jenkins has no local copies of the branches so we need to consult the remote branches
 * to find out which branch we are working on. In multi-branch Jenkins jobs the GIT_BRANCH variable is provided by
 * Jenkins, but it is missing in single-branch jobs, so we can't rely on that.
 *
 * More info:
 *  - http://stackoverflow.com/a/19457164 (the solution was based on this answer)
 *  - http://stackoverflow.com/questions/35554983/git-variables-in-jenkins-workflow-plugin (does not work for branch)
 *
 * @return git branch name
 *
 * Example call:
 *
 * String branch = getGitBranch()
 */
String call() {

    // Explaining the different steps of the piped command:
    //
    // 1. List all branches which contain the commit specified by the current HEAD. This might give back multiple
    //    branches as the same commit might be present in multiple branches (via merges).
    //
    // 2. Let's select that branch where the most recent commit is the same as the last commit of the
    //    current HEAD. This reduces the number of possible branches to one as the last commit of the different
    //    branches are (usually) different. There is one exception: if there are two branches with the same last
    //    commit, which is the case after a merge.
    //
    // 3. Let's take the first line of previous output. This step will arbitrarily reduce the number of possible
    //    branches to one by selecting the first one. This might lead to returning the "wrong" branch name in the end,
    //    but there is no way to select the "correct" one as if we have multiple options in this step that means
    //    that there were multiple identical branches in the previous step.
    //
    // 4. With sed let's remove the not wanted parts of the output, namely: the 'origin/' bit of the branch name and
    //    everything else after the first space (the commit message). The results is the (local) branch name.

    String command = 'git branch --remote --verbose --no-abbrev --contains ' +
            '| grep $(git log --pretty=format:"%H" -1) ' +
            '| head -1 ' +
            '| sed -Ene \'s/^[^\\/]*\\/([^\\ ]+).*$/\\1/p\''

    String gitBranch = getShOutput(command)

    gitBranch
}