def call(String command){
  if(command == "build"){
     pipeline{
       agent any
       stages{
         stage("Build"){
            steps{
              sh 'mvn --version'
            } 
          }
       }
     }
  }
  else if(command == "deploy"){
    pipeline{
      agent any
      stages{
        stage("deploying"){
          steps{
            echo "deploying your app"
          }
        }
      }
    }
  }
}
