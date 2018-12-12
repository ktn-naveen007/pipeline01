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
step([$class: 'Publisher', reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
}

stage('packaging'){
sh '''
mvn package -DskipTests 
'''
/* mvn package -Dmaven.test.skip=true  */

artifactName = sh(script:'dir /target/\\*.jar',returnStdout: true).trim()
}
stage("uploading ${artifactName}"){
    sh """
	    rm -f ~/Downloads/Artifacts
        mkdir ~/Downloads/Artifacts
        cp target/${artifactName} ~/Downloads/Artifacts 
    """
} 
}