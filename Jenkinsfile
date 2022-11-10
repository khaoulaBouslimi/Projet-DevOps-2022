pipeline {
      environment{
        registry = 'raziezzar/achat'
        registryCredential= 'dockerID'
        dockerImage = ''
     }
    agent any

    stages{
        stage('Checkout Git'){
            steps{
                echo 'pulling';
                git branch :'raziezzar',
                url :'https://github.com/khaoulaBouslimi/Projet-DevOps-2022.git',
                credentialsId:'Git-Token';
            }
        }

    stage ("Clean"){
        steps{
                sh "mvn clean"
            }
    }
    stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests'  
            }
        }
    stage ("Package"){
        steps{
                sh "mvn package -DskipTests"
            }
        }

    stage ("Test"){
        steps{
                sh "mvn test"
            }
        }

    stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-sonars',installationName: 'sq1') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=raziezzar \
                    """
                }
                    
            }
                
        }
        stage ("Nexus"){
			steps{
			nexusArtifactUploader artifacts: [[artifactId: 'achat', file: 'target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus', groupId: 'tn.esprit.rh', nexusUrl: '192.168.1.13:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
			}
		}
    
    stage('Building our image'){
         steps{
            script{
               dockerImage= docker.build registry + ":$BUILD_NUMBER"
            }
         }
      }

      stage('Deploy our image'){
         steps{
            script{
               docker.withRegistry( '', registryCredential){
                  dockerImage.push()
               }
            }
         }
      }

      stage('cleaning up'){
         steps{
            sh "docker rmi $registry:$BUILD_NUMBER"
         }
      }
   }
}
