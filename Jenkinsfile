pipeline {
    environment { 
        registry = "kingavatar/SciCal" 
        registryCredential = 'dockerhub_id' 
        dockerImage = '' 
    }


    agent any
    stages{
        stage('VCS CheckOut'){
            steps{
                git 'https://github.com:kingavatar/Scientific-Calculator-with-DevOps.git'
            }
        }
        stage('Unit Testing'){
            steps{
                 gradlew('test')
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage('Assemble'){
            steps{
                gradlew('assemble')
            }
        }
        stage('Building The Docker Image') { 
            steps {
                script { 
                    def version = sh (
                        script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'",
                        returnStdout: true
                        ).trim()
                    dockerImage = docker.build registry + ":$version" 
                }
            } 
        }
        stage('Deploy The Docker Image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
        stage('Cleaning up') { 
            steps { 
                script { 
                    def version = sh (
                        script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'",
                        returnStdout: true
                        ).trim()
                }
                sh "docker rmi $registry:$version" 
            }
        } 
    }
}