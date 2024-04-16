def call() {
    withSonarQubeEnv('sonar-server') {
        sh """ $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Zomato -Dsonar.projectKey=Zomato """
    }
}