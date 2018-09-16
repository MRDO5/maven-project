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
		      sh "docker login credentialsId: 'docker-hub' 
		      sh "docker push martin55/tomcatwebapp:${env.BUILD_ID}"
                }
	     }
         }
     }


