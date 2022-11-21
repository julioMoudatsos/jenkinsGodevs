pipeline{
    def mvnHome
    stage('Clone') {
        git branch: 'dev', url: 'https://github.com/julioMoudatsos/jenkinsGodevs.git'
        mvnHome = tool '/usr/bin/mvn'
        CODE_SC_HG = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
    }

    stage('Test') {
       sh "'${mvnHome}/bin/mvn' test "

    }

    stage('Install') {
        sh "'${mvnHome}/bin/mvn' -DskipTests clean install "
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test2') {
            steps {
                sh 'mvn test -Dmaven.test.failure.ignore=true'
            }
            post {
                success {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                    sh '/var/lib/jenkins/workspace/spring-java/scripts/deliver.sh'
                
            }
        }
        
    }
}