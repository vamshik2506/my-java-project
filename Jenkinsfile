pipeline {
    agent any

    environment {
        // Set up environment variables for SonarQube and other tools
        SONARQUBE = 'SonarQube'
        MAVEN_HOME = '/usr/share/maven' // Change path if different
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    // Install Maven if not already installed
                    sh 'mvn clean install -DskipTests'
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                script {
                    // Run JUnit tests
                    sh 'mvn clean test'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                script {
                    // Run JaCoCo for code coverage
                    sh 'mvn jacoco:report'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube analysis
                    sh 'mvn sonar:sonar -Dsonar.projectKey=my-java-project -Dsonar.host.url=http://localhost:9000'
                }
            }
        }
    }

    post {
        success {
            echo "Build and tests passed successfully!"
        }

        failure {
            echo "Build failed, please check the logs!"
        }
    }
}
