node {
    timeout(time: 60, unit: 'MINUTES') {
            timestamps {
                def cfg = [
                ]
                doWork(cfg)
            }
    }
}

void doWork(cfg) {
    stage('Checkout') {
        cleanWs()
        checkout scm
    }
    stage("Seed Jobs"){
        jobDsl targets: 'jobs/**/*Jobs.groovy', additionalClasspath: 'src/'
    }  
    // stage("Seed Configuration"){
    //      sh("cp config/jenkins.yaml ${JENKINS_HOME}/jenkins.yaml")
    //      sh("cp config/theme/rs.css ${JENKINS_HOME}/userContent/rs.css")
    //      load('scripts/ApplyJenkinsConfiguration.groovy')
    // }
}