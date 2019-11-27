import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
 
import static com.raresociopath.jenkins.data.StaticData.Jobs

pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    logRotator(7, 500)    
    parameters {
        def Params = DSLParams.get(delegate)            
        Params.dslVersion()
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}