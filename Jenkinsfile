@Library('Jenkins-Shared-Library') _
def COLOR_MAP = [
    'SUCCESS': 'GREEN',
    'FAILURE': 'RED',
    'ABORTED': 'YELLOW'
]

pipeline {
    agent any
    parameters {
        choice(name: 'action', choices: 'create\ndelete', description: 'Select to create and destroy')
        string(name: 'DOCKER_HUB_USERNAME', defaultValue: 'claw4321', description: 'Docker Hub Username')
        string(name: 'IMAGE_NAME', defaultValue: 'zomato', description: 'Docker Image Name')
    }
    tools {
        jdk 'jdk17'
        nodejs 'node20'
    }
    environment {
        SCANNER_HOME=tool 'sonar-scanner'
    }
    stages{
        stage('clean workspace'){
            steps{
                cleanWorkspace()
            }
        }
        stage('checkout from Git'){
            steps{
                checkoutGit('https://github.com/itachi-utcha/Zomato-Clone.git', 'main')
            }
        }
        stage('SonarQube Analysis'){
            when {
                expression { params.action == 'create' }}
            steps{
                sonarqubeAnalysis()
            }
        }
        stage('sonarqube QualitGate'){
        when { expression { params.action == 'create'}}    
            steps{
                script{
                    def credentialsId = 'sonar-text'
                    qualityGate(credentialsId)
                }
            }
        }
        stage('Npm'){
        when { expression { params.action == 'create'}}    
            steps{
                npmInstall()
            }
        }
//     post {
//     always {
//         echo 'Slack Notifications'
//         slackSend (
//             channel: 'jenkins12',
//             color: COLOR_MAP[currentBuild.currentResult],
//             message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} \n build ${env.BUILD_NUMBER} \n More info at: ${env.BUILD_URL}"
//         )
//     }
// }
}
}