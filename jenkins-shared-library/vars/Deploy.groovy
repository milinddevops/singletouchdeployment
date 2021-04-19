void call(String env,String jobRundeckId,String jenkinsJobName,String jenkinsBuildId) {
    if(env == 'dev') {
        step([$class: "RundeckNotifier",
        includeRundeckLogs: true,
        jobId: "c3c58254-ac06-4ff2-820b-0016a10de0cf",
        options: """
            build_id=${jenkinsJobName}_${jenkinsBuildId}
            env=DEV
        """,
        rundeckInstance: "Rundeck",
        shouldFailTheBuild: true,
        shouldWaitForRundeckJob: true,
        tailLog: true])
    }
}