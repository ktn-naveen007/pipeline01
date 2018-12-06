node('master')
{
  def envVars = [:]
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
}