pipeline {
	environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
	}
    agent any
    stages {
        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                   git branch: 'facture', credentialsId: 'tokengit', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022.git'}
                
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
      /*  stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'sonartoken',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=12833907 \
                    """
                  }
                    
                  }
                
         }*/
	     stage ("Nexuspackage"){
			steps{
			sh "mvn package"          
            } 
        }
         stage ("Nexusdeploy"){
	steps{
	sh "mvn deploy"

	}
	}
	    stage('Build image') {
            steps{
            script{
            dockerImage = docker.build("souissimouhanned/devops:latest")
            }
            }
        }
        stage('Dockerhub Login') {

			steps {
				sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
			}
		}
        
        
        stage('Push') {

			steps {
				sh 'docker push souissimouhanned/devops:latest'
			}
	}
        
    }
}

