pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'       // Define this in Jenkins > Global Tools Configuration
        jdk 'JAVA_HOME'          // Define this in Jenkins > Global Tools Configuration
    }

    environment {
        SONARQUBE_SERVER = 'MySonarQube' // Optional: define SonarQube in Jenkins settings
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

        // Optional: add this if SonarQube is configured
        // stage('SonarQube Analysis') {
        //     steps {
        //         withSonarQubeEnv('MySonarQube') {
        //             sh 'mvn sonar:sonar'
        //         }
        //     }
        // }

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
