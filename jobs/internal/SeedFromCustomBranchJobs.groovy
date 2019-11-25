import com.raresociopath.jenkins.jobs.dsl.DSL
import com.raresociopath.jenkins.jobs.dsl.ParamsDsl
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    logRotator(7, 500)    
    parameters {
        def Param = ParamsDsl.get(delegate)            
        Param.dsl()
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}