
pipeline{

    agent any

    stages{
        stage('Build Jar File'){
            steps{
                echo "building jar file from the source code"
                sh "mvn clean package -DskipTests"
                echo "jar files building completed now";
             }
        }
        stage('Build docker Image'){
             steps{
                echo " starting with bulding selenium image for the code"
                sh "docker build -t=guptahitesh4u/selenium"
                echo "building image completed"
             }
        }
        stage('Push the docker image'){
            environment{
                DOCKER_HUB=credentials('dockerhub-creds')
            }
             steps{
                            echo " pushing the docker image"

                            bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                            sh "docker push guptahitesh4u/selenium"
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
