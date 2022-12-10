pipeline {
 agent any
 stages {
 stage('Build') {
 steps {
  timeout(time: 1, unit: 'MINUTES') {
     sh 'mvn test -Dtest="DevTest"'
  
  }

     sh 'pwd'
 }
 }
 }
}
