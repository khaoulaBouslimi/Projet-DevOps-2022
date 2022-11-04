
    pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'khaoula', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022'
                }
                
            }
        
        stage('Docker build'){
            steps {
                 sh 'docker build -t khoukha/projet .'
            }
        }
        
        
        

            

    }
}

            
