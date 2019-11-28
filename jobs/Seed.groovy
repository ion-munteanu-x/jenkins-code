import com.raresociopath.jenkins.dsl.DSL
import com.raresociopath.jenkins.dsl.DSLParams
 
import static com.raresociopath.jenkins.data.StaticData.Jobs

pipelineJob(Jobs.Seed) {
    displayName("Seed jenkins")
    logRotator(7, 500)    
    new DSL(this).pipeline(delegate, 'Seed', 'master')
}