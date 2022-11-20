pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               git 'https://github.com/MateusTeixeiraFolha/goDevs.git'
            }
        }
        
         stage('Test') {
            steps {
                 sh './mvn test'
            }
        }
         stage('Deploy') {
            steps {
                echo 'Deploy World'
            }
             post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }

        }
    }
}
