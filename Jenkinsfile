<<<<<<< HEAD
=======

pipeline{
>>>>>>> ffe0428303e9d7f35e0815c0af9594674bb750a7

pipeline{
    agent none

    stages{
        stage('Build Jar File'){
            agent{
                docker{
                    image maven:eclipse-temurin
                }
            }
            steps{
                echo "building jar file from the source code"
                sh "mvn clean package -DskipTests"
                echo "jar files building completed now";
             }
        }
        stage('Build docker Image'){
             steps{
<<<<<<< HEAD
                script{
                app=docker.build('guptahitesh4u/selenium')
                }
=======
                echo " starting with bulding selenium image for the code"
                bat "docker build -t=guptahitesh4u/selenium ./"
                echo "building image completed"
>>>>>>> ffe0428303e9d7f35e0815c0af9594674bb750a7
             }
        }
        stage('Push the docker image'){
            environment{
                DOCKER_HUB=credentials('dockerhub-creds')
            }
             steps{
<<<<<<< HEAD
                script{
                            docker.withRegistry('','dockerhub-creds'){
                            app.push("latest")
                            }
                }
            }
=======
                            echo " pushing the docker image"

                            bat 'echo %DOCKER_HUB_PSW% | docker login -u %DOCKER_HUB_USR% --password-stdin'
                            bat "docker push guptahitesh4u/selenium"
                            echo "image pushed"
             }
>>>>>>> ffe0428303e9d7f35e0815c0af9594674bb750a7
        }
    }
<<<<<<< HEAD
=======
    post{
        always{
            bat "docker logout"
        }
    }

>>>>>>> ffe0428303e9d7f35e0815c0af9594674bb750a7
}
