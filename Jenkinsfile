
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
                sh 'docker-compose up'
                sh 'docker-compose ps'
            }
        }
	    
	    
    }
	    
    post{
        always{
            sh 'docker-compose down'
            sh 'docker-compose ps'
        }
    }	    
	    
	    
}

            
