package com.raresociopath.jenkins.dsl

import com.raresociopath.jenkins.util.Cloning
import com.raresociopath.jenkins.data.Repositories


class DSLScm {

    private Map<String, String> envvars
    private PrintStream logger
    private Cloning cloner
    private Repositories repos = new Repositories();

    DSLScm(container) {
        this.envvars = container.binding.variables
        this.logger = envvars.get('out') as PrintStream
        this.cloner = new Cloning(container)
    }

    void declareHere(delegate, version = null) {
        delegate.scm {
            git {
                branch(version ?: repos.JenkinsJobs.defaultBranch)
                remote {
                    url repos.JenkinsJobs.cloneUrl(cloner)
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