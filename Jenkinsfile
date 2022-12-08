pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh "mvn test -Dmaven.test.failure.ignore=true"
         dir("target") { sh "ls" }
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
   
 }
}
