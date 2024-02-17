pipeline {
    agent { label 'win-agent1'}

    stages {
        stage('Build git maven repo') {
            steps {
                checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mahen035/stud-svc']])
                bat 'mvn clean install'

            }
        }
        stage('Building docker image'){
            steps{
                bat 'docker build -t shrbobde/temp-jetkins-agent .'
            }
        }
        stage('Running Docker Image form jenkins'){
            steps{
                bat 'docker run --name mycontainer1 --network docker-demo-network1 -p 8091:8090 -d shrbobde/temp-jenkins-agent'

            }
        }

    }
}
