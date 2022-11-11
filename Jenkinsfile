
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
                sh 'mvn compile '  
            }
        }
        

        stage('JUNIT & Mockito '){
            steps{
                echo"With this command, one can run project testing steps.";
                sh 'mvn test'
            }
        }  
        
        stage('Build'){
            steps {
                sh 'mvn clean package '
            }
            post{
                success{
                    jacoco()

                }
            }
        }   
        
        stage('SonarQube Analysis'){
            steps {
                withSonarQubeEnv(credentialsId: 'jenkins-soonar',installationName: 'sonarqube') {
                    sh """
                        mvn sonar:sonar \
                        -D sonar.projectKey=org.springframework.boot \
                        -D sonar.host.url=http://192.168.1.20:9000  \
                        -D sonar.login=admin \
                        -D sonar.password=sonar \
                        -D sonar.projectBaseDir=C:/Users/khaoula/Desktop/clone/Projet-DevOps-2022
                    """
                }
                    
            }
                
        }



        stage('Nexus Stage'){
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
                        nexusUrl: '192.168.1.20:8081', 
                        nexusVersion: 'nexus3', 
                        protocol: 'http', 
                        repository: 'Achat-release', 
                        version: '1.0'
            }
        }
        
  
        stage('Docker image'){
            steps {
                 sh 'docker build -t khoukha/achat-spring .'
            }
        }

        stage('pushing to DockerHub'){
            steps {
                withCredentials([string(credentialsId: 'dockerhubId', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u khoukha -p ${dockerhubpwd}'
                    sh 'docker push khoukha/achat-spring'
                }
            }
        }

       stage('DockerCompose') {
                       steps {
				            sh 'docker-compose up -d'
                        }
        }

    }
}

            
