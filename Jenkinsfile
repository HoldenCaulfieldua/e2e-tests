pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'bash mvnw clean verify site'
            }
        }
        stage('Report') {
            steps {
                echo 'Reporting..'
            }
        }
    }
}
