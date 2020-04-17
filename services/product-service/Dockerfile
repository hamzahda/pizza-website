FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/product*.jar /product-service.jar
CMD ["java","-jar","/user-service.jar"]
EXPOSE 8082
