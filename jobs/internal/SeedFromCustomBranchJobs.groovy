import com.raresociopath.jenkins.rs.dsl.DSL
import com.raresociopath.jenkins.rs.dsl.DSLParams
 
import static com.raresociopath.jenkins.rs.data.RS.Jobs
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    logRotator(7, 500)    
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.namespace()
        Params.dsl()
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}