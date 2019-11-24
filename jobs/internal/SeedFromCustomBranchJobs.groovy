import com.raresociopath.jenkins.jobs.dsl.DSL
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
 
pipelineJob(Jobs.SeedCustom) {
    displayName("Seed from a custom branch")
    parameters {
        stringParam('Dsl_Version', 'master', "Version of your feature jenkins jobs branch")
    }
    new DSL(this).pipeline(delegate, 'internal/SeedFromCustomBranch', '${Dsl_Version}')
}