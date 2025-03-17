Step 1: Build the application
mvn clean package
testing on local machine(command line terminal)
java -jar target/emp-crud-app-pipeline-0.0.1-SNAPSHOT.jar  

Step 2: Build the Docker image

docker build -t emp-crud-app-pipeline .

docker images

Step 3:
Run the Docker Container:
Run the container locally to test it:
docker run -p 8080:8080 emp-crud-app-pipeline
Step 4:
Check the container logs to ensure the application is running.
docker ps
Step 5:
You can also manually test the health endpoint:
curl http://localhost:8080/actuator/health
------------------ECR--------------------
create ecr repository
emp-crud-app-ecr
