
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


              
        
        

            

    }
}

            
