
    pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'khaoula', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022'
                }
                
            }
        
        stage('build'){
            steps {
                sh 'mvn clean package -DskipTests'
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
                        nexusUrl: '192.168.1.22:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'Achat-release', 
                        version: '1.0'
            }
        }
        
        
        

            

    }
}

            
