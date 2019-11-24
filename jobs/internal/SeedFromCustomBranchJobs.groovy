import com.raresociopath.jenkins.jobs.dsl.DSL
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
import com.raresociopath.jenkins.jobs.dsl.ParamDSL.dslParam
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    parameters {
        dslParam(delegate)
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}