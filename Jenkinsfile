node {
    stage('Build') {
        sh 'mvn clean package'
        }
     stage('Build Docekr images'){
         sh "docker build . -t martin55/tomcatwebapp:${env.BUILD_ID}"
        }
     stage('Push Docker image'){
            withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockpass')]) {
            sh "docker login -u martin55 -p ${dockpass}"
            sh 'docker push martin55/tomcatwebapp:${BUILD_ID}'
        }
      stage ('Runing container on Dev server'){
         def dockerRun="docker run -d -p 8080:8080 martin55/tomcatwebapp:${BUILD_ID}"
	 sshagent(['vmssh']) {
           sh "ssh -o StrictHostKeyChecking=no root@192.168.88.202 ${dockerRun}"
          }
       }
    }
 }
