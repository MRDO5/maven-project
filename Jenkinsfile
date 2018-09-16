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
                steps { 
 		   sh "docker build . -t tomcatwebapp:${env.BUILD_ID}"
		  }
	        }
	 stage('Push Docker image'){ 
                steps {
  		   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'duck-pwd')]) { 
		   sh "docker login -u martin55 -p ${duck-pwd}" 
		   } 
  	         }
		steps {
		   sh "docker push  tomcatwebapp:${env.BUILD_ID} martin55/testtomcatap:${env.BUILD_ID}"
                }
	     }
         }
     }


