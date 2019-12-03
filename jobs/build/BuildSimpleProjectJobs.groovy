import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
import com.raresociopath.jenkins.data.GlobalVars
import com.raresociopath.jenkins.data.Repositories
import com.raresociopath.jenkins.util.Cloning

import static com.raresociopath.jenkins.data.StaticData.Jobs

Cloning cloner = new Cloning(this)
def Repos = new Repositories()

def choices = Repos.AllProjects.findAll { it.isSimpleProject() }.collect { cloner.cloneUrl(it) }
choices.add(0, "")

Repos.AllProjects.findAll { it.isSimpleProject() }.each { proj ->
    pipelineJob(proj.distJobId) {
        displayName("Build ${proj.humanName}")
        description("This project assumes that repository contains Dockerfile file in project's root")
        logRotator(7, 50)
        parameters {
            def Param = DSLParams.get(delegate)
            Param.ref('Repo_Ref', proj)
            Param.forceRebuild()
            Param('Override_Docker_Image_Name', '', 'fill if you want to override default value, which is repository name')
            Param.dslVersion()
        }
        environmentVariables {
            GlobalVars.inject(delegate)
            env('Repo_Url', cloner.cloneUrl(proj))
        }
        new DSL(this).pipeline(delegate, 'build/BuildSimpleProject', '${Dsl_Version}')
    }
}