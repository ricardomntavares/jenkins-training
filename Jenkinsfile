/* groovylint-disable BlockStartsWithBlankLine, CompileStatic, GStringExpressionWithinString, LineLength */
pipelineJob('WEB/WEB-RELEASE-NOTES') {
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
            useRepository('https://github.com/ricardomntavares/jenkins-training.git') // Use your test repo
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
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('ricardomntavares/jenkins-training') // Update to your test project repo
                        credentials('jenkins-nbcu-access-bot')  // Use appropriate credentials for your repo
                    }
                    branch('main')
                    extensions {
                        cleanBeforeCheckout()
                        cleanCheckout {
                            deleteUntrackedNestedRepositories(true)
                        }
                        cloneOptions {
                            noTags(false)
                            shallow(false)
                            timeout(10)
                            reference("${GIT_REFERENCE_REPOS_PATH}/jenkins-training") // Optional reference for optimization
                        }
                    }
                }
            }
            scriptPath('jenkins/release_notes_jenkinsfile') // Adjust path if necessary
        }
    }
    description('''Generates and publishes release notes for the given app version and release date.
Pulls changes from version control, formats them, and optionally updates documentation or notifies stakeholders.
Notes include: release info, highlights, release features, technical specs, gating issues, feature flags, bug fixes, known issues and other updates based on commit history or changelog.''')
    logRotator {
        numToKeep(20)
    }
}
