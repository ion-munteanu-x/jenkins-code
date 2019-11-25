import com.raresociopath.jenkins.jobs.dsl.DSL
import com.raresociopath.jenkins.jobs.dsl.ParamsDsl
 
import static com.raresociopath.jenkins.jobs.StaticConstants.Jobs
 
pipelineJob(Jobs.BuildHelloWorld) {
    displayName("Build Hello World")
    parameters {
        def Param = ParamsDsl.get(delegate)
        Param('String', '', 'string')
        Param.dsl()
    }
    new DSL(this).pipeline(delegate, 'build/BuildHelloWorld', '${Dsl_Version}')
}