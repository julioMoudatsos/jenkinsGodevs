pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/julioMoudatsos/jenkinsGodevs.git'
                sh 'git clone https://github.com/julioMoudatsos/jenkinsGodevs.git '
                // bat '.\\mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
                // bat '.\\mvnw test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
