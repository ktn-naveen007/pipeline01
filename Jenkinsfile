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
 artifactName = sh(script:'''#!/usr/bin/env bash
                            ls target/*.jar
                        ''',returnStdout: true).trim() 

}
stage('uploading'){
    
    sh """#!/usr/bin/env bash
	          cp ${artifactName} ~/Downloads/Artifacts 
    """
} 
}