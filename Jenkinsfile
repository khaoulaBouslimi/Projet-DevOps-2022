
    pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'khaoula', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022'
                }
                
            }
        
        
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-soonar',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.projectKey=org.springframework.boot \
                        -Dsonar.host.url=http://192.168.1.23:9000  \
                        -D sonar.login=admin \
                        -D sonar.password=sonar \
                        -D sonar.projectBaseDir=C:/Users/khaoula/Desktop/clone/Projet-DevOps-2022
                    """
                }
                    
            }
                
        }
        
        
        
        

            

    }
}

            
