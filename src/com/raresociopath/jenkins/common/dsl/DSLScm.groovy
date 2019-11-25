package com.raresociopath.jenkins.common.dsl

import com.raresociopath.jenkins.common.util.Cloning
import com.raresociopath.jenkins.common.data.RSRepositories


class DSLScm {

    private Map<String, String> envvars
    private PrintStream logger
    private Cloning cloner
    private RSRepositories repos = new RSRepositories();

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