pipeline {
    agent any
    
    stages {
        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'Fournisseur', credentialsId: 'gittoken', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022.git'
                }
                
            }
        stage('Clean'){
            steps {
                   sh 'mvn clean'
                }
        }
        stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests'  
            }
        }
       /* 
        stage('JUnit and Mockito Test'){
             steps{

                sh 'mvn --batch-mode test'
             }

         }
       
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'sonartoken',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=hamzawi2120 \
                        -D sonar.projectKey=org.springframework.boot \
                        -D sonar.host.url=http://192.168.1.109:9000  
                    """
                }
                    
            }
                
        } */
        
        stage ("Nexuspackage"){
			steps{
			sh "mvn package -DskipTests"          
            } 
        }
         stage ("Nexusdeploy"){
	steps{
	sh "mvn deploy -DskipTests"

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
