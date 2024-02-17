pipeline {
    agent { label 'win-agent1'}

    stages {
        stage('Build git maven repo') {
            steps {
                checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/HashBob/demo-test']])
                bat 'mvn clean install -DskipTests'

            }
        }
        stage('Building docker image'){
            steps{
                bat 'docker build -t shrbobde/temp-jenkins-agent .'
            }
        }
        stage('Running Docker Image form jenkins'){
            steps{
                bat 'docker run --name mycontainer1 --network docker-demo-network1 -p 8091:8090 -d shrbobde/temp-jenkins-agent'

            }
        }

    }
}
