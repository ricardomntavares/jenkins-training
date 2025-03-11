pipeline {
    agent any

    parameters {
        gitParameter {
            branch('')
            branchFilter('.*')
            defaultValue('')
            description('''The tag to build and deploy.
Ex:
- tag: jenkins-training-v1.0.0''')
            name('RELEASE_TAGS')
            quickFilterEnabled(true)
            requiredParameter(true)
            selectedValue('NONE')
            sortMode('DESCENDING_SMART')
            tagFilter('*release*')
            type('PT_TAG')
            useRepository('https://github.com/ricardomntavares/jenkins-training.git')
        }
        string(
            name: 'RELEASE_DATE',
            defaultValue: new Date().format('dd/MM/yyyy', TimeZone.getTimeZone('Europe/Lisbon')),
            description: 'Release date (dd/MM/yyyy)',
            trim: true
        )
        string(name: 'CVSDK_VERSION', description: 'CVSDK version', trim: true)
        choice {
            choices(['MAJOR', 'MINOR', 'HOTFIX'])
            name('BUILD_TYPE')
        }
        choice {
            choices(['web', 'xtv', 'roku', 'mobile', 'appletv'])
            name('PROJECT')
        }
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
