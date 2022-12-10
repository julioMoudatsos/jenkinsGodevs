pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dmaven.test.failure.ignore=true'
            }
            post {
                success {
                    junit 'target/surefire-reports/*.xml'
                    sh 'kill -9 `lsof -t -i:8081` || echo "nada na porta 8081"'
                }
            }
        }
        stage('Deliver') {
            steps {
                    sh 'java -jar target/goDevs-0.0.1-SNAPSHOT.jar'
                
            }
        }
        
    }
}
