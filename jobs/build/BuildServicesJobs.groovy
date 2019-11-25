import com.raresociopath.jenkins.rs.dsl.DSL
import com.raresociopath.jenkins.rs.dsl.DSLParams
 
import static com.raresociopath.jenkins.wh.data.WH.Jobs
 
pipelineJob(Jobs.HelloWorld) {
    displayName("Build Hello World")
    parameters {
        def Params = DSLParams.get(delegate) 
        Params("String", "", "String")           
        Params.dsl()
    }
    new DSL(this).pipeline(delegate, 'build/BuildHelloWorld', '${Dsl_Version}')
}