package com.raresociopath.jenkins.common.dsl

import com.raresociopath.jenkins.common.models.RSRepository
import com.raresociopath.jenkins.common.util.Cloning


class DSLParams {

    static DSLParams get(delegate) {
        new DSLParams(delegate)
    }

    private Object del

    DSLParams(d) {
        this.del = d
    }

    void call(name) {
        ParamDSL.paramT(name, del)
    }

    void call(name, value) {
        ParamDSL.paramT(name, value, del)
    }

    void call(name, value, description) {
        ParamDSL.paramT(name, value, description, del)
    }

    void url(name, RSRepository repo, Cloning cloner) {
        call(name, cloner.cloneUrl(repo), "A link to clone the ${repo.humanName}.")
    }

    void ref(name, RSRepository repo, version = null, Boolean canBeEmpty = null) {
        def appendix = canBeEmpty ? (repo.isDeployable() ? ' Empty means ~don\'t-deploy~.' : ' Empty means ~don\'t use~.') : ''
        call(name, version != null ? version : repo.defaultBranch, "Version of the ${repo.humanName}.${appendix} Can be one one of tag, branch, full commit sha or shorter prefix of it.")
    }

    void dsl(version = null) {
        ParamDSL.dslParam(version, del)
    }

    void shortRepoRef(RSRepository repo, versionOrCanBeEmpty = null, Boolean canBeEmpty = null) {
        if (versionOrCanBeEmpty instanceof Boolean && canBeEmpty == null) {
            ref(repo.shortRepoParam, repo, null, versionOrCanBeEmpty)
        } else {
            ref(repo.shortRepoParam, repo, versionOrCanBeEmpty, canBeEmpty)
        }
    }

    void helmArgs(String name, String info) {
        helmArgs(name, null, info)
    }

    void helmArgs(String name, String defaultValue, descriptionPrefix) {
        call(name, defaultValue ?: '', "Place for additional helm arguments${descriptionPrefix ? " for $descriptionPrefix" : ""}, comma-separated, format key=value[,key=value]. [Escape ',' by \\]")
    }

    // just DRY

    def suggestedNamespace(defaultOne = '') {
        call('Suggested_Namespace', defaultOne, 'Suggest namespace to be used for this deployment.')
    }

    def forceRebuild(defaultOne = false) {
        call('Force_Rebuild', defaultOne, 'Whether to force rebuild.')
    }

    def namespace(defaultOne = '') {
        call('Namespace', defaultOne, 'Specify which namespace should be used for this deployment.')
    }

    def subnet(defaultOne = '') {
        call('Subnet', defaultOne, 'Subnet to use for deployment, empty will use default defined in the Infra')
    }

    def vpc(defaultOne = '') {
        call('VPC', defaultOne, 'VPC to use for deployment, empty will use default defined in the Infra')
    }

    def securityGroup(defaultOne = '') {
        call('Security_Group', defaultOne, 'Security group to use for deployment, empty will use default defined in the Infra')
    }

    def extraInfraArgs(defaultValue = null) {
        helmArgs('Extra_Infra_Args', defaultValue, 'infrastructure')
    }

    def extraServicesArgs(defaultValue = null) {
        helmArgs('Extra_Services_Args', defaultValue, 'services')
    }

    def useNgStubs(defaultValue) {
        call('Use_NG_Stubs', defaultValue, 'Whether to use ng-stubs')
    }

    def runISpecs(defaultValue = true) {
        call('Run_ISpecs', defaultValue, 'Whether to run ISpecs.')
    }
}