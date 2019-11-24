import com.raresociopath.jenkins.jobs.dsl.DSL
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
 
pipelineJob(Jobs.BuildHelloWorld) {
    displayName("Build Hello World")
    parameters {
        stringParam('STRING', 'Simple string')
    }
    new DSL(this).pipeline(delegate, 'build/BuildHelloWorld', 'master')
}