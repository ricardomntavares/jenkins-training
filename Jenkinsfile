pipeline {
    agent any

    parameters {
        // Git parameter to select a release tag
        gitParameter(
            name: 'RELEASE_TAG',
            type: 'PT_TAG',  // PT_TAG for selecting tags
            branchFilter: '.*', // Regex to match all tags
            defaultValue: '',  // Default value
            description: 'Select the release tag to build',
            selectedValue: 'NONE',  // Default selection when no value is chosen
            sortMode: 'DESCENDING_SMART',  // Sort tags, DESCENDING_SMART sorts by most recent
            tagFilter: '*release*',  // Only tags with 'release' in their name will appear
            quickFilterEnabled: true
        )
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the selected tag (provided by the gitParameter)
                    checkout scm
                }
            }
        }

        stage('Build and Deploy') {
            steps {
                script {
                    // Just an example to show the selected release tag
                    echo "Building with release tag: ${params.RELEASE_TAG}"

                    // Add your build/deployment steps here
                    // For example, you can use the selected tag to checkout specific code
                    sh "git checkout ${params.RELEASE_TAG}"

                    // Further deployment or build steps can follow here
                }
            }
        }
    }
}
