import com.raresociopath.jenkins.common.dsl.DSL
import com.raresociopath.jenkins.common.dsl.DSLParams
 
import static com.raresociopath.jenkins.common.data.RSStaticConstants.Jobs
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    logRotator(7, 500)    
    parameters {
        def Param = DSLParams.get(delegate)            
        Param.dsl()
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}