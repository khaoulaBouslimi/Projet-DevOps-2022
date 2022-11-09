pipeline {
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
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'sonartoken',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=12833907 \
                    """
                  }
                    
                  }
                
         }
         stage ("Nexus"){
			steps{
			nexusArtifactUploader artifacts: [[artifactId: 'achat', file: 'target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus', groupId: 'tn.esprit.rh', nexusUrl: '192.168.1.15:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-releases', version: '1.0'
			}
		}
    
        
    }
}

