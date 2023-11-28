node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/powerlinegoport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/powerlinegoport.git'), string(name: 'PORT_DESCRIPTION', value: 'powerline-go' ), string(name: 'BUILD_LINE', value: 'DEV'), string(name: 'NODE_LABEL', value: "go_120" ) ]
  }
}
