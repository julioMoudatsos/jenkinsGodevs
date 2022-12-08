pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh "'ls'"
         dir("target") { sh "mvn test" }
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
   
 }
}
