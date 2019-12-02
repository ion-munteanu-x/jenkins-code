import com.raresociopath.jenkins.dsl.DSLScm
import com.raresociopath.jenkins.dsl.DSLParams

job("internal/SignatureApprove") {
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.dslVersion()
    }
    wrappers {
        timestamps()
    }
    steps {
        systemGroovyScriptFile(readFileFromWorkspace('groovy-scripts/ApproveSignatures.groovy'))
    }
}