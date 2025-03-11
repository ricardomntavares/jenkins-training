pipeline {
    agent any

    parameters {
        string(
            name: 'RELEASE_TAGS',
            defaultValue: '',
            description: '''The tag to build and deploy.
Ex:
- tag: gst-apps-web-v.3.1.8'''
        )
        string(
            name: 'RELEASE_DATE',
            defaultValue: new Date().format('dd/MM/yyyy', TimeZone.getTimeZone('Europe/Lisbon')),
            description: 'Release date (dd/MM/yyyy)',
            trim: true
        )
        string(
            name: 'CVSDK_VERSION',
            description: 'CVSDK version',
            trim: true
        )
        choice(
            name: 'BUILD_TYPE',
            choices: ['MAJOR', 'MINOR', 'HOTFIX'],
            description: 'Select the build type'
        )
        choice(
            name: 'PROJECT',
            choices: ['web', 'xtv', 'roku', 'mobile', 'appletv'],
            description: 'Select the project'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                    url: 'https://github.com/ricardomntavares/jenkins-training.git', 
                    credentialsId: 'jenkins-nbcu-access-bot'
            }
        }

        stage('Generate Release Notes') {
            steps {
                script {
                    // Your script logic to generate release notes
                    echo "Generating release notes for tag ${params.RELEASE_TAGS}..."
                }
            }
        }

        // Add additional stages as necessary for your project
    }

    post {
        success {
            echo 'Release notes generated successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
