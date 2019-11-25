package com.raresociopath.jenkins.rs.util

import com.raresociopath.jenkins.models.Repository

class Cloning {

    private Map<String, String> envvars;
    private PrintStream logger;

    String defaultCloneMethod = "ssh"

    Cloning(container) {
        this.envvars = container.binding.variables
        this.logger = envvars.get('out') as PrintStream
    }

    String cloneUrl(Repository repo) {
        String cloneMethod = envvars.get('SCM_CLONE_METHOD').toLowerCase()
        if (!(cloneMethod == 'ssh' || cloneMethod == 'https')) {
            logger.println("ERROR: clone method not set as SCM_CLONE_METHOD variable, fallback to $defaultCloneMethod")
            cloneMethod = defaultCloneMethod
        }
        repo.cloneUrl(cloneMethod == 'ssh', envvars.get('SCM_SERVER'))
    }
}