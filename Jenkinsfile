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
 		   sh "docker build . -t martin55/ntomcatwebapp:${env.BUILD_ID}"
		  }
	        }
	 stage('Push Docker image'){ 
                steps {
  		   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'duck-pwd')]){ 
		       sh "docker login -u martin55 -p ${duck-pwd}" 
		   } 
  	           sh "docker push martin55/testtomcatap:${env.BUILD_ID}"
                }
	     }
         }
     }


