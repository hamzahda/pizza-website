FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/user-service*.jar /user-service.jar
ADD wait.sh /
RUN chmod +x /wait.sh
CMD ["java","-jar","/user-service.jar"]
EXPOSE 8081
