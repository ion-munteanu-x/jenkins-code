package com.raresociopath.jenkins.jobs.dsl

class JobDslScm {

    private Map<String, String> envvars
    private PrintStream logger

    JobDslScm(container) {
        this.envvars = container.binding.variables
        this.logger = envvars.get('out') as PrintStream
    }

    void declareHere(delegate, version = null) {
        delegate.scm {
            git {
                branch(version ?: master)
                remote {
                    url "https://github.com/raresociopath/rs-jenkins-jobs.git"
                    credentials envvars.get('SCM_CREDENTIALS_ID')
                }
                extensions {
                    wipeOutWorkspace()
                    cloneOptions {
                        depth(1)
                    }
                }
            }
        }
    }
}