
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
                bat "docker build -t=guptahitesh4u/selenium ./"
                echo "building image completed"
             }
        }
        stage('Push the docker image'){
            environment{
                DOCKER_HUB=credentials('dockerhub-creds')
            }
             steps{
                            echo " pushing the docker image"

                            bat 'echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin'
                            bat "docker push guptahitesh4u/selenium"
                            echo "image pushed"
             }
        }

    }
    post{
        always{
            bat "docker logout"
        }
    }

}
