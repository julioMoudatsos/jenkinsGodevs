pipeline {
 agent any
  stages {
 
      stage('Testes de Sanidade') {
       steps {
         sh "'pwd'"
         sh "'ls'"
         sh 'cd target/'
         sh "'pwd'"
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
    stage('Unitarios') {
       steps {
         sh 'echo "Hello World"'
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
    stage('Teste Integrados') {
       steps {
         sh 'echo "Hello World"'
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
 }
}
