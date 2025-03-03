pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ricardomntavares/jenkins-training', branch: 'main')
      }
    }

    stage('List files and folders') {
      steps {
        sh 'ls -ltra'
      }
    }

  }
}