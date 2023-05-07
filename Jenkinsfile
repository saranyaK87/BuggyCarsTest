pipeline {
    agent {
        docker {
        image 'maven:3.9.1-amazoncorretto-20'
        args '-u root'}
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
             post {
                    always {
                      // Publish the TestNG report
                      junit 'target/surefire-reports/*.xml'
                    }
                  }
        }
    }
}