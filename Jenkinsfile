pipeline {
    agent any

    environment {
        MAVEN_HOME = '/path/to/maven' // Replace with Maven's actual path on Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Clean and build the Maven project
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }
        stage('Test') {
            steps {
                // Run test cases
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
        stage('Generate Reports') {
            steps {
                // Archive test reports
                archiveArtifacts artifacts: 'reports/*.html', fingerprint: true
                publishHTML([target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'extentReport.html',
                    reportName: 'Extent Test Report'
                ]])
            }
        }
    }

    post {
        always {
            // Notifications or cleanup actions
            echo "Build completed."
        }
    }
}
