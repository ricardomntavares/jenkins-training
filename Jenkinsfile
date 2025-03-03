pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ricardomntavares/jenkins-training', branch: 'main')
      }
    }

    stage('List files and folders') {
      parallel {
        stage('List files and folders') {
          steps {
            sh 'ls -ltra'
          }
        }

        stage('Front-End Unit Tests') {
          steps {
            sh 'cd curriculum-front && npm i && npm run test:unit'
          }
        }

      }
    }

    stage('Build') {
      steps {
        sh 'docker build -f curriculum-front/Dockerfile . -t fuze365/curriculum-front:latest'
      }
    }

    stage('Login to Dockerhub') {
      environment {
        DOCKERHUB_USER = '123'
        DOCKERHUB_PASSWORD = '123'
      }
      steps {
        sh 'docker login -u $DOCKERHUB_USER -p $DOCKERHUB_PASSWORD'
      }
    }

    stage('Push to Dockerhub') {
      steps {
        sh 'docker push fuze365/curriculum-front:latest'
      }
    }

  }
}