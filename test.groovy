#!/usr/bin/env groovy

def call(){
   

   pipeline {
    
    agent {
      label  'slave'
    }

    stages {
        
        stage('install nginx') {
            steps {
               sh 'sudo apt install nginx -y'
            }
        }
        stage('start nginx') {
            steps {
                sh "sudo systemctl nginx enable"
                 sh "sudo systemctl nginx start"
            }    
        }
       stage('test nginx') {
            steps {
                sh "curl localhost "
            }    
        }
       
    }
  
}
}

