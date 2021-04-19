void call() {
    sleep 45
    timeout(time: 4, activity: false, unit: 'MINUTES') {
        def qg = waitForQualityGate()

        if(qg.status != 'OK') {
            error "Code quality scan failed.${qg.status}"
        }
    }
}