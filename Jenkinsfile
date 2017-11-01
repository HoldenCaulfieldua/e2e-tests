pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
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
