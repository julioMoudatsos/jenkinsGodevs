pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh "mvn test"
         dir("target") { sh "ls" }
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
   
 }
}
