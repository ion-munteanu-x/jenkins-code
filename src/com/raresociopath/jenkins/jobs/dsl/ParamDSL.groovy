package com.raresociopath.jenkins.jobs.dsl

import com.raresociopath.jenkins.jobs.dsl.kubeconfig.KubeconfigSupport
import javaposse.jobdsl.dsl.DslScriptException

import static com.raresociopath.jenkins.models.StaticProductRepositories.JenkinsJobs

class ParamDSL {
    private static def paramImpl(String name, value, String desc, delegate, paramDefinitionContext) {
        // below line will work only if delegate is called in a extra { code block }, it will fail if called directly in "parameters { param(...) }" <- this is weird
        def logger = null
        try {
            logger = delegate.binding?.variables?.get('out')
        } catch (Exception ignore) {
        }
        try {
            if (value instanceof Boolean) {
                delegate.booleanParam(name, value, desc?.toString() ?: '')
            } else if (value instanceof List) {
                delegate.choiceParam(name, value.collect { it.toString() }, desc?.toString() ?: '')
            } else if (value instanceof String || value instanceof GString) {
                delegate.stringParam(name, value, desc?.toString() ?: '')
            } else {
                throw new IllegalArgumentException("Unknown value type: ${value.getClass().getCanonicalName()} for param $name")
            }
        } catch (DslScriptException e) {
            def ctxMsg = paramDefinitionContext == null ? " in $paramDefinitionContext" : ''
            logger?.println("Ignoring error ${e.getMessage()}${ctxMsg}")
        }
    }

    static def paramT(String name, value, desc, delegate, context) {
        paramImpl(name, value, desc, delegate, context)
    }

    static def paramT(String name, value, desc, delegate) {
        paramImpl(name, value, desc, delegate, null)
    }

    static def paramT(name, value, delegate) {
        paramImpl(name, value, '', delegate, null)
    }

    static def paramT(name, delegate) {
        paramImpl(name, '', '', delegate, null)
    }

    static def dslParam(delegate) {
        if (delegate instanceof String) {
            throw new IllegalArgumentException("argument passed to dslParam(delegate) should be a delegate, not a string")
        }
        dslParam(null, delegate)
    }

    static def dslParam(value, delegate) {
        paramImpl('Dsl_Version', value ?: JenkinsJobs.defaultBranch, 'Jobs DSL version', delegate, null)
    }

    static def clusterParam(delegate) {
        clusterParam(null, null, delegate)
    }

    static def clusterParam(value, delegate) {
        clusterParam(value, null, delegate)
    }

    static def clusterParam(value, note, delegate) {
        KubeconfigSupport.clusterParamV2(delegate, value, note)
    }
}