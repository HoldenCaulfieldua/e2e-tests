node {
    
        stage('Build') {
            print(pwd())
                //sh 'mvnw -Dmaven.test.failure.ignore=true clean verify site'
            sh 'mvn clean verify'
        }
         stage('Report') {
                    
                        publishHTML([reportName  : 'Allure Report', reportDir: 'target/site/allure-maven-plugin', reportFiles: 'index.html',
                                     reportTitles: '', allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false])
                    
                }
    }
    post {
        always {
            deleteDir()
        }
        failure {
            slackSend message: "${env.JOB_NAME} - #${env.BUILD_NUMBER} failed (<${env.BUILD_URL}|Open>)",
                    color: 'danger', teamDomain: 'qameta', channel: 'allure', tokenCredentialId: 'allure-channel'
        }
    
}
