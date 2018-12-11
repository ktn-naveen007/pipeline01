node('master'){
def artifactName = null
stage('initialize'){
checkout scm
}
stage('compile'){
 sh '''
mvn compile
'''
}
stage('unittest'){
sh '''
mvn test
'''
}
stage('automation'){
sh'''
mvn clean test -Dsuite=DevOps
'''
}
stage('packaging'){
sh '''
mvn package
'''
artifactName = sh(script:'@dir target\\*.jar /b',returnStdout: true).trim()
}
stage("uploading ${artifactName}"){
    sh """
	    rm -f ~/Downloads/Artifacts
        mkdir ~/Downloads/Artifacts
        cp target/${artifactName} ~/Downloads/Artifacts 
    """
}
}