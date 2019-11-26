import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
import com.raresociopath.jenkins.data.GlobalVars
import com.raresociopath.jenkins.data.Repositories
import com.raresociopath.jenkins.util.Cloning

import static com.raresociopath.jenkins.data.StaticData.Jobs

Cloning cloner = new Cloning(this)
def Repos = new Repositories()

def choices = Repos.AllProjects.findAll { it.isRawProject() }.collect { cloner.cloneUrl(it) }
choices.add(0, "")

pipelineJob(Jobs.BuildRawProject) {
    displayName("Build raw project")
    description("This project assumes that repository contains Dockerfile file in project's root<br/>" +
            "You can provide REPO_URL parameter, but it would be simpler to use one of predefined urls<br/>" +
            "for use one of predefined, simply select one of possible url in PREDEFINED_LOW_PRECEDENCE_REPO_URL<br/>" +
            "and leave REPO_URL unchanged.")
    logRotator(7, 50)
    parameters {
        def Param = DSLParams.get(delegate) 
        Param('Repo_Url', 'url to repository, any of format, https or ssh', '')
        Param('Repo_Ref', 'develop', 'Reference to do checkout')
        Param("Predefined_Low_Precedence_Repo_Url", choices, '')
        Param.forceRebuild()
        Param('Override_Docker_Image_Name', '', 'fill if you want to override default value, which is repository name')
        Param.dsl()
    }
    environmentVariables {
        GlobalVars.putHere(delegate)
    }
    new DSL(this).pipeline(delegate, 'build/BuildRawProject', '${Dsl_Version}')
}

Repos.AllProjects.findAll { it.isRawProject() }.each { proj ->
    pipelineJob(proj.distJobId) {
        displayName("Build docker image of ${proj.humanName}")
        description("This project assumes that repository contains Dockerfile file in project's root<br/>" +
                "You can provide REPO_URL parameter, but it would be simpler to use one of predefined urls<br/>" +
                "for use one of predefined, simply select one of possible url in PREDEFINED_LOW_PRECEDENCE_REPO_URL<br/>" +
                "and leave REPO_URL unchanged.")
        logRotator(7, 50)
        parameters {
            def Param = DSLParams.get(delegate) 
            Param.ref('Repo_Ref', proj)
            Param.forceRebuild()
            Param('Override_Docker_Image_Name', '', 'fill if you want to override default value, which is repository name')
            Param.dsl()
        }
        environmentVariables {
            GlobalVars.putHere(delegate)
            env('Repo_Url', cloner.cloneUrl(proj))
        }
        new DSL(this).pipeline(delegate, 'build/BuildRawProject', '${Dsl_Version}')
    }
}