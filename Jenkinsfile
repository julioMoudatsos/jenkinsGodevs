pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
<<<<<<< HEAD
                echo 'Build World'
=======
                git 'https://github.com/julioMoudatsos/jenkinsGodevs.git'
                sh './mvn clean compile'
                // bat '.\\mvnw clean compile'
>>>>>>> 2987e47b48c15f7d91a7954ed9d7637a9ec10eea
            }
        }
        
         stage('Test') {
            steps {
<<<<<<< HEAD
                echo 'Test World'
=======
                sh './mvn test'
                // bat '.\\mvnw test'
>>>>>>> 2987e47b48c15f7d91a7954ed9d7637a9ec10eea
            }
        }
         stage('Deploy') {
            steps {
                echo 'Deploy World'
            }
        }
    }
}
