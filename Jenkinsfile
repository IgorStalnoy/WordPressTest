pipeline {
    agent any
        parameters{
        choice(choices: ['CHROME', 'EDGE', 'FIREFOX'], description: 'Please choose browser', name: 'browser')
        choice(choices: ['DESKTOP', 'MOBILE'], description: 'Please choose device', name: 'device')
    }

    stages {
        stage('Test') {
            steps {

                git 'https://github.com/IgorStalnoy/WordPressTest.git'

                bat "mvn clean test -Dbrowser=${params.browser} -Ddevice=${params.device}"

            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
            ])
            }
            }
        }
    }
}