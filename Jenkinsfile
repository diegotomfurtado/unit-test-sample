import jenkins.model.*
jenkins = Jenkins.instance

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