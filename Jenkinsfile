pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/julioMoudatsos/jenkinsGodevs.git'
                sh './mvn clean compile'
                // bat '.\\mvnw clean compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvn test'
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
