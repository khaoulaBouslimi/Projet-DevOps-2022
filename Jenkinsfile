
    pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo "Getting Project from GitHub";
                git branch: 'khaoula', credentialsId: 'MyGitHubCredential', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022.git'
            }
        }
    
     
        stage('Clean'){
            steps {
                sh 'mvn clean '
            }
        }
    


       stage('Docker Compose') {
            steps {
                sh 'docker-compose up -d'
            }
        }
	    
	    
    }
}

            
