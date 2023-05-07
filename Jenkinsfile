pipeline {
    agent {
        docker { image 'maven:3.9.1-amazoncorretto-20' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}