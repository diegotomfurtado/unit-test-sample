import jenkins.model.*

def username = 'Jenkins'
node {
	 stage('Build') {
		 echo 'Building..'
	 	 echo "Hello Mr. ${username}"
		 deleteDir()
		 checkout scm
	 }
	 stage('Test') {
		 echo
		'Testing..'
	 }
	 stage('Deploy') {
		 echo
		'Deploying....'
	 }
} 