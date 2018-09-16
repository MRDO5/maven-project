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
 		   sh "docker build . -t martin55/tomcatwebapp:${env.BUILD_ID}"
		  }
	        }
	 stage('Push Docker image'){ 
                steps {
		   withCredentials([usernameColonPassword(credentialsId: 'docker-hub', variable: 'dock-hub')])
		      sh "docker login ${duck-hub}" 
		   } 
  	           sh "docker push martin55/tomcatwebapp:${env.BUILD_ID}"
                }
	     }
         }
     }


