pipeline {
  environment { 
    registry = "kingavatar/scical" 
    registryCredential = 'dockerhub_id' 
    dockerImage = '' 
    version= ""
  }

  agent any

  triggers {
        pollSCM '* * * * *'
  }

  stages{
    stage('VCS CheckOut'){
			steps{
				git branch:'main', url:'https://github.com/kingavatar/Scientific-Calculator-with-DevOps.git'
			}
		}
		stage('Unit Testing'){
			steps{
				//  gradlew('test')
				sh './gradlew clean test'
				junit '**/build/test-results/test/TEST-*.xml'
			}
		}
		stage('Assemble'){
			steps{
				// gradlew('assemble')
				sh './gradlew clean assemble'

			}
		}
		stage('Building The Docker Image') { 
			steps{
				script{ 
					version = sh (
						script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'",
						returnStdout: true
						).trim().toLowerCase()
					dockerImage = docker.build registry + ":$version" 
				}
			} 
		}
		stage('Deploy The Docker Image') { 
			steps{ 
				script{ 
					docker.withRegistry( '', registryCredential ) { 
							dockerImage.push()
              dockerImage.push("latest")
						}
				} 
			}
		} 
		stage('Cleaning up') { 
			steps{ 
				script{ 
					version = sh (
							script: "./gradlew properties -q | grep \"version:\" | awk '{print \$2}'",
							returnStdout: true
							).trim()
				}
				sh "docker rmi $registry:$version" 
			}
		}
    stage('Deploy on Node'){
      steps{
        script{
          step([
            $class: "RundeckNotifier",
            includeRundeckLogs: true,
            rundeckInstance: "Rundeck",
            jobId: "8b09b4bf-1ada-4475-a2e6-9b896c5a1687",
            shouldWaitForRundeckJob: true,
            shouldFailTheBuild: true,
            tailLog: true
            ])
          }
        }
    }
	}
}
