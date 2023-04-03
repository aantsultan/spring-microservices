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

Here is the example simple rest-api from `currency-exchange` with kubernetes and docker on command line `curl`

    curl http://34.128.76.37:8000/currency-exchange/from/USD/to/INR
    
    {"id":10001,"from":"USD","to":"INR","conversionMultiple":65.00,"environment":"8000 v1 currency-exchange-75b849465-kqd8c"R

And here is the example from `currency-conversion`

    curl http://34.101.184.127:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
    
    {"id":10001,"from":"USD","to":"INR","quantity":10,"conversionMultiple":65.00,"totalCalculatedAmount":650.00,"environment":"8000 v1 currency-exchange-75b849465-kqd8c feign"}
