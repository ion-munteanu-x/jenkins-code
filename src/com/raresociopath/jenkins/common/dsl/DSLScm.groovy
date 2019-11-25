package com.raresociopath.jenkins.common.dsl

import static com.williamhill.jenkins.models.StaticProductRepositories.JenkinsJobs

class JobDslScm {

    private Map<String, String> envvars
    private PrintStream logger
    private Cloning cloner

    JobDslScm(container) {
        this.envvars = container.binding.variables
        this.logger = envvars.get('out') as PrintStream
        this.cloner = new Cloning(container)
    }

    void declareHere(delegate, version = null) {
        delegate.scm {
            git {
                branch(version ?: JenkinsJobs.defaultBranch)
                remote {
                    url JenkinsJobs.cloneUrl(cloner)
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