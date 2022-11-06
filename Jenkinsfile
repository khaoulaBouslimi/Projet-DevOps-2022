
    pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'khaoula', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022'
                }
                
            }
        
        stage('Clean'){
            steps {
                echo "You are using the clean command, which will delete all previously compiled Java .class files and resources (like .properties) in your project. Your build will start from a clean slate.";
                    
                sh 'mvn clean -DskipTests '
            }
        }
            
        stage('Compile'){
            steps {
                sh 'mvn compile -DskipTests'  
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

            
