Step 1: Build the application
mvn clean package
testing on local machine(command line terminal)
java -jar target/emp-crud-app-pipeline-0.0.1-SNAPSHOT.jar  

Step 2: Build the Docker image on local

docker build -t emp-crud-app-pipeline .

to check images
docker images -a

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

to see the running containers
docker ps
to delete the container
docker rm -f emp-crud-app-pipeline
-----------------------------------------------------------------------
All below steps are in AWS console, should have account
Step 6:
create ecr(elastic container registry) repository, which is similar to docker hub
as emp-crud-app-ecr, this is specified in buildspec.yml file
you can get the information after clicking the "View push commands" button,
then copy the commands to buildspec.yml

Step 7: CodeBuild


Step 8: ECS(Elastic Container Service)
ECS cluster contains backend service, which contains the backend task definition that is the image from ECR

create cluster
create task definition
create service
application load balancer

CMD-SHELL,curl -f http://localhost:8080/actuator/health || exit 1

Step 9: CodePipeline

build code pipeline 

