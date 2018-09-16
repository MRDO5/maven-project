pipeline {
     agent any 

    tools {
        maven 'localMaven'
        }
     stages{
        stage('Build'){
                steps { 
                   sh 'mvn clean package'
	  	  }
	        }
	stage('Build Docekr images'){  
                 sh "docker build . -t tomcatwebapp:${env.BUILD_ID}"
		  }
	stage('Push Docker image') { 
             steps {
		withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhub-pwd')])
		sh "docker login -u martin55 -p ${dockerhub-pwd}"
		sh "docker push  martin55/testtomcatap:1"
              }
	   }
        }
     }

