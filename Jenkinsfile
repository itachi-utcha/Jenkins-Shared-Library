@Library('Jenkins-Shared-Library') _
def COLOR_MAP = [
    'SUCCESS': 'GREEN',
    'FAILURE': 'RED',
    'ABORTED': 'YELLOW'
]

pipeline {
    agent any
    parameters {
        string(name: 'BRANCH', defaultValue: 'master', description: 'Branch to build')
    }
}