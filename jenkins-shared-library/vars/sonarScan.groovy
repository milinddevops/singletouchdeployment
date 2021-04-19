void call() {
    withSonarQubeEnv('sonarqubeserver') {
       sh "mvn -f pom.xml sonar:sonar"
    }
}