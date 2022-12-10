pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh 'sudo mvn test -Dtest="DevTest"'
     
       }
   }
   
 }
}
