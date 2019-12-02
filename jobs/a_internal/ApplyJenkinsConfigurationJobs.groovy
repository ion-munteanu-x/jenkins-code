import com.raresociopath.jenkins.dsl.DSLScm
import com.raresociopath.jenkins.dsl.DSLParams

job("internal/ApplyConfiguration") {
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.dslVersion()
    }
    wrappers {
        timestamps()
    }
    steps {
        systemGroovyScriptFile('groovy-scripts/ApplyJenkinsConfiguration.groovy')
    }
}