// for downloading repositories from github
def getGit(repo){
   git "${repo}"
}

// for building .war
def buildApp(){
   sh "mvn package"
}
// for Deploying build to servers
def DeployAppTesting(ip,deploytoappname){
   deploy adapters: [tomcat9(credentialsId: 'd9cb3bc8-87b7-4f0f-9bd5-715451addf26', path: '', url: 'http://172.19.0.3:8080/')], contextPath: 'mywebapp', war: '**/*.war'
}

// for testing 
def Test(repo,workspace,jar_name){
  git  "${repo}"
  sh "java -jar /var/jenkins_home/workspace/${workspace}/${jar_name}.jar"
}

def DeployAppProd(ip,deploytoappname){
   deploy adapters: [tomcat9(credentialsId: 'd9cb3bc8-87b7-4f0f-9bd5-715451addf26', path: '', url: 'http://172.19.0.4:8080/')], contextPath: 'mywebapp', war: '**/*.war'
}

 
