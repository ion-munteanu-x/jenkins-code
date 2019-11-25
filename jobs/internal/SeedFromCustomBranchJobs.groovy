import com.raresociopath.jenkins.common.dsl.DSL
import com.raresociopath.jenkins.common.dsl.ParamsDsl
 
import static com.raresociopath.jenkins.common.data.StaticConstants.Jobs
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    logRotator(7, 500)    
    parameters {
        def Param = ParamsDsl.get(delegate)            
        Param.dsl()
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}