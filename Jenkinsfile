pipeline {
    agent any

    tools {
        maven "maven"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/karthiktu/helloworld.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean compile package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('SonarCloud') {
              environment {
                SCANNER_HOME = tool 'sonar_scanner'
                ORGANIZATION = "helloworld"
                PROJECT_NAME = "helloworld"
              }
              steps {
                withSonarQubeEnv('SonarCloudOne') {
                    sh '''$SCANNER_HOME/bin/sonar-scanner -Dsonar.organization=$ORGANIZATION \
                    -Dsonar.java.binaries=build/classes/java/ \
                    -Dsonar.projectKey=$PROJECT_NAME \
                    -Dsonar.sources=.'''
                }
  }
}
    }
}
