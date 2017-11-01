pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify site'
            }
        }
        stage('Report') {
            steps {
                echo 'Reporting..'
            }
        }
    }
}
