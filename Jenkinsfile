
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
                script{
                app=docker.build('guptahitesh4u/selenium')
                }
             }
        }
        stage('Push the docker image'){
             steps{
                script{
                            docker.withRegistry('','dockerhub-creds'){
                            app.push("latest")
                            }
                }
            }
        }
    }
}
