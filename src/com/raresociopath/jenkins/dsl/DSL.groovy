package com.raresociopath.jenkins.dsl

class DSL {

    private Map<String, String> envvars
    private PrintStream logger
    private DSLScm dslUtil

    DSL(container) {
        this.envvars = container.binding.variables
        this.logger = envvars.get('out') as PrintStream
        this.dslUtil = new DSLScm(container)
    }
    
    void pipeline(d, String name, version = null) {
        def jenkinsfileFullPath = "jenkinsfiles/$name"
        if (!jenkinsfileFullPath.endsWith("Jenkinsfile")) {
            jenkinsfileFullPath += "Jenkinsfile"
        }
        d.definition {
            cpsScm {
                dslUtil.declareHere(delegate, version)
                lightweight(false)
                scriptPath jenkinsfileFullPath
            }
        }
    }
}
