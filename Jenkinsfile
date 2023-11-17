pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                cleanWs()
                git branch: 'develop', url: 'https://github.com/Saif-Doghri/achat.git'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Integration Test') {
                    steps {
                        sh 'mvn verify -DskipUnitTests'
                    }
                }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
