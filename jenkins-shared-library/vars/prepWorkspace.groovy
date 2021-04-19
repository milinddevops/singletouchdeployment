void call(String gitUrl,String creds){
  try {
  
    extWorkspace = exwsAllocate 'DiskPool'

    exws (extWorkspace) {
      checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ credentialsId: creds, url: gitUrl]]])

    }
  }
  catch(err) {
    echo "failed" + err
    currentBuild.result = "FAILURE"
    WORKSPACESTATUS = "FAILED"
    WORKSPACECOL = "RED"
    WORKSPACECUSTOMMSG = "prepWorkspace stage not completed. Please check errors."
    sh 'exit 1'
  }
}