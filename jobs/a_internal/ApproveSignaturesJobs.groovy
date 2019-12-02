import com.raresociopath.jenkins.jobs.dsl.DSLScm
import com.raresociopath.jenkins.dsl.DSLParams

job("internal/SignatureApprove") {
    jdk('java')
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.dslVersion()
    }
    wrappers {
        timestamps()
    }
    steps {
        systemGroovyScriptFile('groovy-scripts/ApproveSignatures.groovy')
    }
}