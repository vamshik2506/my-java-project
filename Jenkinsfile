pipeline {
    agent any

    tools {
        maven 'Maven3'       // You configured this in Global Tool Config ✅
        jdk 'jdk11'          // Also configured this ✅
    }

    environment {
        SONARQUBE_SERVER = 'MySonarQube' // (Optional) if you configure SonarQube later
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vamshik2506/my-java-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test & Coverage') {
            steps {
                sh 'mvn test jacoco:report'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([reportDir: 'target/site/jacoco', reportFiles: 'index.html', reportName: 'JaCoCo Coverage'])
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build, Test, and Package completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
