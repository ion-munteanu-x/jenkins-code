#!groovy

/**
 * Prints the shell and Jenkins build environment info.
 *
 * Example call:
 *
 * envInfo()
 */
def call(sort = true) {

    echo 'Shell environment:'
    if (sort) {
        sh 'env | sort'
    } else {
        sh 'env'
    }
    echo 'Jenkins environment:'
    echo toPrettyJson([
            'environment'         : env.getEnvironment(),
            'overridenEnvironment': env.getOverriddenEnvironment(),
    ])
}