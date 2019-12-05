@Library("rs-library@feature/10") _
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
    stage("Seed Configuration"){
         sh("cp config/jenkins.yaml ${JENKINS_HOME}/jenkins.yaml")
         load("groovy-scripts/ApplyJenkinsConfiguration.groovy")
    }    
    stage("Seed Jobs"){
        jobDsl targets: 'jobs/**/*Jobs.groovy', additionalClasspath: 'src/'
    }  
}