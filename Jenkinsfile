pipeline {
    agent any
    tools {
        maven "maven3.2"
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/karthiktu/helloworld.git'

                sh "mvn -Dmaven.test.failure.ignore=true clean compile package"

            }

        }
    }
}
