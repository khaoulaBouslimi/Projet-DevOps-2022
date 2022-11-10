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
                sh 'mvn compile'  
            }
        }
        
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'sonartoken',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=hamzawi2120 \
                    """
                }
                    
            }
                
        }
        stage('Test'){
            steps {
                   sh 'mvn test'
                }
        }
        
    }
}
