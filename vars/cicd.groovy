// for downloading repositories from github
def getGit(repo){
   git ${repo}
}

// for building .war
def buildApp(){
   sh "maven package"
}
// for Deploying build to servers
def DeployApp(workspace,ip,deploytoappname){
  sh "scp /var/jenkins_home/workspace/${workspace}/webapp/target/webapp.war  ubuntu@${ip}:/usr/local/tomee/webapps/${deploytoappname}.war"
}

// for testing 
def Test(repo,workspace,jar_name){
  git  ${repo}
  sh 'java -jar /var/jenkins_home/workspace/${workspace}/${jar_name}.jar'
}


