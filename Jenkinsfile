pipeline {
     agent any 

    tools {
        maven 'localMaven'
        }
     stages{
        stage('Build'){
                steps {
                   sh 'mvn clean package'
		   sh "docker buid . -t tomcatwebapp:${env.BUILD_ID}
                }
             }
          }
      }


