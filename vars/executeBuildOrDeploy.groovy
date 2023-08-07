def call(String command){
  if(command == "build"){
     pipeline{
       agent any
       tools {
         maven 'maven'
       }   
       stages{
         stage("Build"){
            steps{
              sh 'mvn -v'
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
