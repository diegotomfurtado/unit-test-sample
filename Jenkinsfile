
@Field final gitRepository = 'diegotomfurtado/unit-test-sample'
@Field final projectName = "DevOps"
@Field final projectKey  = "unit-test-sample"

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
