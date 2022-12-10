pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh 'sudo -S mvn test -Dtest="DevTest"'
     
       }
   }
   
 }
}
