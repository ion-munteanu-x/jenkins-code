import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
import com.raresociopath.jenkins.data.GlobalVars
import com.raresociopath.jenkins.data.Repositories
import com.raresociopath.jenkins.util.Cloning

import static com.raresociopath.jenkins.data.StaticData.Jobs

pipelineJob(Jobs.DownstreamJob1) {
        displayName("FirstJob")
        description("This is first job")
        logRotator(7, 50)
        parameters {
            def Param = DSLParams.get(delegate) 
            Param('test_string', '', 'this string will be printed')
            Param.dslVersion()
        }
        new DSL(this).pipeline(delegate, 'downstream/FirstJob', '${Dsl_Version}')
    }

pipelineJob(Jobs.DownstreamJob2) {
        displayName("DelegatedJob")
        description("Delegated job")
        logRotator(7, 50)
        parameters {
            def Param = DSLParams.get(delegate) 
            Param('delegated_string', '', 'this string is from another job')
            Param('other_string', '', 'this string will be printed')
            Param.dslVersion()
        }
        new DSL(this).pipeline(delegate, 'downstream/SecondJob', '${Dsl_Version}')
    }