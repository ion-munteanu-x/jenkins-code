package com.raresociopath.jenkins.dsl

import com.raresociopath.jenkins.models.Repository
import com.raresociopath.jenkins.util.Cloning


class DSLParams {

    static DSLParams get(delegate) {
        new DSLParams(delegate)
    }

    private Object del

    DSLParams(d) {
        this.del = d
    }

    void call(name) {
        DSLParam.paramT(name, del)
    }

    void call(name, value) {
        DSLParam.paramT(name, value, del)
    }

    void call(name, value, description) {
        DSLParam.paramT(name, value, description, del)
    }

    void url(name, Repository repo, Cloning cloner) {
        call(name, cloner.cloneUrl(repo), "A link to clone the ${repo.humanName}.")
    }

    void ref(name, Repository repo, version = null, Boolean canBeEmpty = null) {
        def appendix = canBeEmpty ? (repo.isDeployable() ? ' Empty means ~don\'t-deploy~.' : ' Empty means ~don\'t use~.') : ''
        call(name, version != null ? version : repo.defaultBranch, "Version of the ${repo.humanName}.${appendix} Can be one one of tag, branch, full commit sha or shorter prefix of it.")
    }

    void pipelineVersion(version = null) {
        DSLParam.dslParam(version, del)
    }

    void shortRepoRef(Repository repo, versionOrCanBeEmpty = null, Boolean canBeEmpty = null) {
        if (versionOrCanBeEmpty instanceof Boolean && canBeEmpty == null) {
            ref(repo.shortRepoParam, repo, null, versionOrCanBeEmpty)
        } else {
            ref(repo.shortRepoParam, repo, versionOrCanBeEmpty, canBeEmpty)
        }
    }

    def forceRebuild(defaultOne = false) {
        call('Force_Rebuild', defaultOne, 'Whether to force rebuild.')
    }    
}