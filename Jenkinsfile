def username = 'Jenkins'

node {
 stage('Build') {
	echo 'Building..'
	echo "Hello Mr. ${username}"
 }
 stage('Checkout') {
	checkout scm
 }

 stage('Test') {
	echo 'Testing..'
 }
 stage('Deploy') {
	echo 'Deploying....'
 }
}