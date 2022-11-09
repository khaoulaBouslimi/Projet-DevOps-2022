pipeline {
    agent any

    stages {
       stage('Cloning from GitHub') {
                steps {
                    echo "Getting Project from Git";
                    
                    git branch: 'Fournisseur', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022', credentialsId: 'hamzatoken'
                }
                
            }
    }
}
