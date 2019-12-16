import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
import com.raresociopath.jenkins.data.GlobalVars
import com.raresociopath.jenkins.data.Repositories
import com.raresociopath.jenkins.util.Cloning

import static com.raresociopath.jenkins.data.StaticData.Jobs

pipelineJob(Jobs.TestJobsFolder) {
        displayName("Build TEST")
        description("This is a test job")
        logRotator(7, 50)
        parameters {
            def Param = DSLParams.get(delegate) 
            Param('test_string', '', 'this string will be printed')
            Param.dslVersion()
        }
        new DSL(this).pipeline(delegate, 'test/BuildSimpleProjectTest', '${Dsl_Version}')
    }
