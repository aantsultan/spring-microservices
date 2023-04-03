MICROSERVICES WITH SPRING-BOOT AND SPRING-CLOUD
-

This application is running based on `docker-compose.yaml`

To **running** application, please use command terminal below in your root directory project

    docker-compose up

To **stop** application, just typing `Ctrl + C` in terminal

To **build** docker-image, you have to enter into your specific module directory such as `api-gateway` , `currency-exchange`, `currency-conversion` or `naming-server` with command terminal such as below

    mvn spring-boot:build-image -DskipTests

To **create** service and deployment (pods) on kubernetes, please use module `[module]-kubernates`. And run command 

    kubectl apply -f deployment.yaml

To **delete** pods on kubernetes, type such as command below

    kubectl delete all -l app=[label]

To *get* value of `label`, you can search in `deployment.yaml`


