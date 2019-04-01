#!groovy
import groovy.transform.Field

def username = 'Jenkins'
node {

	try {
		stage('Build') {
			echo 'Building..'
		 	echo "Hello Mr. ${username}"
			
			echo "Running ${env.JOB_NAME} (${env.BUILD_ID}) at ${env.JENKINS_URL}"

			deleteDir()
			checkout scm
			sh 'cat README.md'

		 }

		 stage('Test') {
			 echo 'Testing..'
		 }

		 stage('Deploy') {
			 echo 'Deploying....'
		 }
	} 
	catch (exc) {
		throw exc
	}
} 
