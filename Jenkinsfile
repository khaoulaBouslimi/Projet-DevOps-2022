
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
                echo "You are using the clean command, which will delete all previously compiled Java .class files and resources (like .properties) in your project. Your build will start from a clean slate.";
                    
                sh 'mvn clean '
            }
        }
            
        stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests'  
            }
        }

        stage('build'){
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }        
        
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-soonar',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.login=admin \
                        -D sonar.password=sonar \
                        -D sonar.projectKey=org.springframework.boot \
                        -D sonar.host.url=http://192.168.1.15:9000  
                        
                    """
                }
                    
            }
                
        }

        stage('Upload the jar To Nexus'){
            steps {
                nexusArtifactUploader artifacts: [
                            [
                                artifactId: 'achat', 
                                classifier: '', 
                                file: 'target/achat-1.0.jar', 
                                type: 'jar'
                            ]
                        ], 
                        credentialsId: 'nexus', 
                        groupId: 'tn.esprit.rh', 
                        nexusUrl: '192.168.1.15:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'Achat-release1', 
                        version: '1.0'
            }
        }
              
        
        

            

    }
}

            
