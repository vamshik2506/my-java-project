pipeline {
    agent any

    tools {
        maven 'Maven 3'  // Add Maven under Global Tool Configuration
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token')  // Jenkins credential ID
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vamshik2506/my-java-project.git' // replace if different
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=your-project-key -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
    }
}
