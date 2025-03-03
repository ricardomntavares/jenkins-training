pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ricardomntavares/jenkins-training', branch: 'main')
      }
    }

    stage('Run groovy script') {
      steps {
        load 'script.groovy'
      }
    }

  }
}