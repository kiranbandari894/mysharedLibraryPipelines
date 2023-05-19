// for downloading repositories from github
def getGit(repo){
   git "${repo}"
}

// for building .war
def buildApp(){
   sh "mvn package"
}
// for Deploying build to servers
def DeployApp(workspace,ip,user,deploytoappname){
   sh "scp /var/jenkins_home/workspace/${workspace}/webapp/target/webapp.war  ${user}@${ip}:/usr/local/tomee/webapps/${deploytoappname}.war"
}

// for testing 
def Test(repo,workspace,jar_name){
  git  "${repo}"
  sh "java -jar /var/jenkins_home/workspace/${workspace}/${jar_name}.jar"
}


