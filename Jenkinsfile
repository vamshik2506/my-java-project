pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vamshik2506/my-java-project.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo '🔧 Building the project and running unit tests...'
                sh 'mvn -B clean test -Dmaven.test.failure.ignore=false -DtrimStackTrace=false -Dsurefire.useFile=false'
                echo '✅ Tests completed.'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        failure {
            echo '❌ Build failed!'
        }
        success {
            echo '🎉 Build succeeded!'
        }
    }
}
