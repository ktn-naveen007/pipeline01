node('Node_Ub'){
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
export DISPLAY=:0
chmod +x ./Drivers/geckodriver
mvn test
'''
}
stage('automation'){
sh'''
mvn test -Dsuite=DevOps
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