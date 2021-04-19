void call(String env,String jobRundeckId,String jenkinsJobName,String jenkinsBuildId) {
    if(env == 'dev') {
        step([$class: "RundeckNotifier",
        includeRundeckLogs: true,
        jobId: "${jobRundeckId}",
        options: """
            build_id=${jenkinsJobName}_${jenkinsBuildId}
        """,
        rundeckInstance: "Rundeck",
        shouldFailTheBuild: true,
        shouldWaitForRundeckJob: true,
        tailLog: true])
    }
}