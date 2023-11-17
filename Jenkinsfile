pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                cleanWs()
                git branch: 'develop', url: 'https://github.com/Saif-Doghri/achat.git'
            }
        }

        stage('Static Analysis') {
                    steps {
                        script{
                            withSonarQubeEnv(credentialsId: 'sonarToken1') {
                             sh 'mvn clean package sonar:sonar'
                            }
                        }
                    }
                }

        stage('Quality Gate') {
                steps {
                    script{
                        waitForQualityGate abortPipeline: false, credentialsId: 'sonarToken1'
                    }
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
        stage('Maven Build') {
                    steps {
                        sh 'mvn clean install'
                    }
                }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
