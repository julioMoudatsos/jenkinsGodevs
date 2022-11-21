node {
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

   
    stage('Deploy') {
        sh "CODE_SC_HG="+ CODE_SC_HG
    }
}