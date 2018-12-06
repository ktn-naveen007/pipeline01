node('master')
{
  def envVars = [:]
stage('initialize'){
envVars.javaHome = tool(name: 'java-jdk', type: 'jdk') + '/jdk1.8.0_152'
envVars.mavenHome = tool name: 'apache-maven-3.3.9', type: 'maven'
checkout scm
}
stage('compile'){
withEnv(["JAVA_HOME=${envVars.javaHome}","M3_HOME=${envVars.mavenHome}"]){
sh '''
mvn compile
'''
 
}
}
stage('unittest'){
withEnv(["JAVA_HOME=${envVars.javaHome}","M3_HOME=${envVars.mavenHome}"]){
   sh '''
       mvn test
   '''
   
}
}
}