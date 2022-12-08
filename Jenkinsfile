pipeline {
 agent any
  stages {
    stage('Build') {
       steps {
         sh 'git clone https://github.com/julioMoudatsos/jenkinsGodevs.git'
         sh '''
         echo "Multiline shell steps works too"
         ls -lah
         '''
       }
   }
   
    stage('Testes de Sanidade') {
       steps {
         sh 'echo "Hello World"'
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
