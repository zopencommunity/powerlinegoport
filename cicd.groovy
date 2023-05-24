node('linux')
{
   
  stage (Poll) {
                checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        userRemoteConfigs: [[url: "https://github.com/ZOSOpenTools/powerline-goport.git"]]])
        }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/powerline-goport.git'), string(name: 'PORT_DESCRIPTION', value: 'A beautiful and useful low-latency prompt for your shell, written in go' )]
  }
}
