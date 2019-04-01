#!groovy
import groovy.transform.Field

@Library("liferay-sdlc-jenkins-lib") import static org.liferay.sdlc.SDLCPrUtilities.*

@Field final gitRepository = 'Liferay/lfrgs-gr1d-innovationcloud'
@Field final projectName = "GR1D"
@Field final projectKey  = "lfrgs-gr1d-innovationcloud"

def username = 'Jenkins'
node {
	 stage('Build') {
		 echo 'Building..'
	 	 echo "Hello Mr. ${username}"
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
