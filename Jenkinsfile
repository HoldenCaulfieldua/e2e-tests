pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                mvnw clean verify site
            }
        }
        stage('Report') {
            steps {
                echo 'Reporting..'
            }
        }
    }
}
