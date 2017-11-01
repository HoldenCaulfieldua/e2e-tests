pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'sudo chmod 777 .mvnw'
                sh './mvnw clean verify site'
            }
        }
        stage('Report') {
            steps {
                echo 'Reporting..'
            }
        }
    }
}
