void call() {
    try {
        sh 'mvn clean package'
    }
    catch(err) {
        echo 'Error: ' + err
        sh 'exit 1'
    }
}