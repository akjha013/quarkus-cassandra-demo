// node {
//     // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
//     def server = Artifactory.server "SERVER_ID"
//     // Create an Artifactory Maven instance.
//     def rtMaven = Artifactory.newMavenBuild()
//     def buildInfo
//
//     stage('Maven build') {
//         buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean install -DskipTests'
//     }
//
//     stage('Publish build info') {
//         server.publishBuildInfo buildInfo
//     }
// }

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
    }
}