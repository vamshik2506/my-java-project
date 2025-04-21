pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Checking out code from GitHub...'
                git 'https://github.com/vamshik2506/my-java-project.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo '🔧 Building the project and running unit tests...'
                sh 'mvn -B clean test -Dmaven.test.failure.ignore=false'
                echo '✅ Tests completed. Check results below.'
            }
        }

        stage('Publish Test Results') {
            steps {
                echo '📊 Publishing JUnit test results...'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo '📦 Archiving build artifacts...'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }

        success {
            echo '🎉 Build succeeded!'
        }

        failure {
            echo '❌ Build failed! Check the logs and test results.'
        }
    }
}
