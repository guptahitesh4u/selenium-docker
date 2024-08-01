FROM bellsoft/liberica-openjdk-centos

#workspace in remote node
WORKDIR /home/selenium-docker

# below will add all contents from docker-resource folder to workdirectory on remote,
ADD target/docker-resources ./

#Environment Variables for Browser and hubPost and test_Suite to execute and threadcounts


ENTRYPOINT java -cp 'libs/*' \
            -Dselenium.grid.enabled=true \
            -Dselenium.grid.hubHost=${HUB_HOST:-hub} \
            -Dbrowser=${BROWSER:-chrome} \
            org.testng.TestNG \
            -threadcount ${THREAD_COUNT:-2} \
            test-suites/${TEST_SUITE:-*.xml}

#run the tests
