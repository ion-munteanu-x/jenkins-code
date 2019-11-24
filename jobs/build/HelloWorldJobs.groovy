import com.raresociopath.jenkins.jobs.dsl.DSL
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
import static com.raresociopath.jenkins.jobs.dsl.ParamDSL.dslParam
 
pipelineJob(Jobs.BuildHelloWorld) {
    displayName("Build Hello World")
    parameters {
        stringParam('STRING', 'Simple string')
        dslParam(delegate)
    }
    new DSL(this).pipeline(delegate, 'build/BuildHelloWorld', '${Dsl_Version}')
}