import com.raresociopath.jenkins.dsl.DSLScm
import com.raresociopath.jenkins.dsl.DSLParams

import static com.raresociopath.jenkins.data.StaticData.Jobs

job(Jobs.ApproveSignaturesJobName) {
    displayName("Approve Signatures")
    jdk('java')
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.dslVersion()
    }
    new DSLScm(this).declareHere(delegate, '${Dsl_Version}')
    wrappers {
        timestamps()
    }
    steps {
        systemGroovyScriptFile('groovy-scripts/ApproveSignatures.groovy')
    }
}