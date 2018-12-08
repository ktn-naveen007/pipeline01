node('master'){
def artifactName = null
stage('initialize'){
checkout scm
}
stage('compile'){
 bat '''
mvn compile
'''
}
stage('unittest'){
bat '''
mvn test
'''
}
stage('packaging'){
bat '''
mvn package
'''
artifactName = bat(script:'@dir target\\*.jar /b',returnStdout: true)
}
stage("uploading ${artifactName}"){
    bat """
        mkdir e:\\naveen_jenkins
        copy "target\\${artifactName}" "e:\\naveen_jenkins" 
    """
}
}