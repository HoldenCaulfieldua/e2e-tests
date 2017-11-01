pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'mvn clean verify site'
            }
        }
        stage('Report') {
            steps {
                echo 'Reporting..'
            }
        }
    }
}
