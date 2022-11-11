pipeline {
    agent any
    
    environment {

        DOCKERHUB_CREDENTIALS = credentials('DockerhubId')
    }
   
    stages {
        stage('GIT'){
            steps {
                git branch: 'AzizBenKbaier', credentialsId:'Git', url: 'https://github.com/khaoulaBouslimi/Projet-DevOps-2022.git'
               
            }
        }
       
        stage('CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
       
        stage('COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
       
        stage('SONAR') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
       
        stage('JUNIT') {
            steps {
                sh 'mvn compile'
            }
        }
       
        stage('NEXUS') {
            steps {
                sh 'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
            }
        }
        stage('Build Maven Spring'){
             steps{
                sh 'mvn clean install '
                 }
        }
                         
        stage('Build docker image'){
            steps{
              script{
                sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/devopsimage:latest .'
               
                 }
            }
         }
         
         stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }
			
         
                         
        stage('Docker login') {
                     steps {
                    sh 'echo "login Docker ...."'
                   	sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                               } 
                               }
        
        stage('Docker push') {
                 steps {
                      sh 'echo "Docker is pushing ...."'
                       sh 'docker push $DOCKERHUB_CREDENTIALS_USR/devopsimage:latest'
                     	 
                        }  
            
        }
        stage('docker compose'){
                         steps{
                                script{
                                 sh ' docker-compose up -d'
                                 }
                           }
          }
       
    }
}
