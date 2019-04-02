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

		 }

		 stage('Test') {
			 echo 'Testing..'
			 try {
			        maven clean install
			
				//gradlew 'build -x test -x testIntegration'
				//gradlew 'build -x test -x testIntegration -x functionalTest'
			} catch (exc) {
				throw exc
			}
		 }

		 stage('Deploy') {
			 echo 'Deploying....'
		 }
	} 
	catch (exc) {
		throw exc
	}
} 
