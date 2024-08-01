pipeline{

    agent any

    stages{

        stage('Build Jar File'){
            steps{
                echo "building jar file from the source code"
                bat "mvn clean package -DskipTests"
                echo "jar files building completed now";
             }
        }
        stage('Build docker Image'){
             steps{
                echo " starting with bulding selenium image for the code"
                bat "docker build -t=guptahitesh4u/selenium"
                echo "building image completed"
             }
        }
        stage('Push the docker image'){
             steps{
                            echo " pushing the docker image"
                            bat "docker push guptahitesh4u/selenium"
                            echo "image pushed"
             }
        }

    }

}