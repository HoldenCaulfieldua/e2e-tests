pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'chmod 777 .mvnw'
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
