void call(String jobName,String buildNumber) {
    try {
            withDockerRegistry(toolName: 'Docker', url: 'https://index.docker.io/v1/', credentialsId: 'DockerHubCredentials',) {
            def custImage = docker.build("milinddocker/cicd:" + jobName + "_" + buildNumber)
            custImage.push()
        }
    }
    catch(err) {
        echo 'Error: ' + err
        sh 'exit 1'
    }
}