// vars/nodejsPipeline.groovy
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent any

        environment {
            CI = 'true'
        }

        stages {
            stage('Build') {
                steps {
                    script {
                        nodejs.NodeJSRunner.runNodeCommandInDocker(config.dockerImage, 'npm install')
                    }
                }
            }
            stage('Test') {
                steps {
                    script {
                        nodejs.NodeJSRunner.runNodeCommandInDocker(config.dockerImage, './jenkins/scripts/test.sh')
                    }
                }
            }
            stage('Deliver') {
                steps {
                    script {
                        nodejs.NodeJSRunner.runNodeCommandInDocker(config.dockerImage, './jenkins/scripts/deliver.sh')
                        input message: 'Finished using the web site? (Click "Proceed" to continue)'
                        nodejs.NodeJSRunner.runNodeCommandInDocker(config.dockerImage, './jenkins/scripts/kill.sh')
                    }
                }
            }
        }
    }
}
