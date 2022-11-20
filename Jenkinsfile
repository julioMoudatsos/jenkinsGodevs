pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/julioMoudatsos/jenkinsGodevs.git'
                sh './mvn test'
           
            }
        }
   
    }
}