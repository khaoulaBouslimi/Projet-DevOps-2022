
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
                    
                    sh 'mvn clean '
                }
                
            }
            
            stage('Compile'){
                steps {
                    sh 'mvn compile -DskipTests'  /// mvn package -DskipTests
                }
                
            }
        
        stage('Nexus'){
            steps{
                sh 'mvn deploy -DskipTests'
            }
        }

            

    }
}

            
