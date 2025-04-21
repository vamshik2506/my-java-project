pipeline {
    agent any

    tools {
        maven 'Maven 3'    // Make sure this matches the Maven tool name configured in Jenkins (Manage Jenkins > Global Tool Configuration)
        jdk 'OpenJDK 17'   // Same here for JDK
    }

    environment {
        PROJECT_NAME = "my-java-project"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Cloning repository..."
                git 'https://github.com/vamshik2506/my-java-project.git'
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling Java code..."
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running JUnit tests..."
                sh 'mvn test'
            }
        }

        stage('Publish Test Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully for ${PROJECT_NAME}"
        }
        failure {
            echo "Pipeline failed. Please check the logs for ${PROJECT_NAME}"
        }
    }
}
