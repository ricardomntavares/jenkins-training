pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ricardomntavares/jenkins-training', branch: 'main')
      }
    }

    stage('') {
      steps {
        sh 'ls -ltra'
      }
    }

  }
}