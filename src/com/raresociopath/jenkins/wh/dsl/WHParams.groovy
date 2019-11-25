package com.raresociopath.jenkins.wh.dsl

import com.raresociopath.jenkins.rs.models.RSRepository
import com.raresociopath.jenkins.rs.util.Cloning


class WHParams extends DSLParams {

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