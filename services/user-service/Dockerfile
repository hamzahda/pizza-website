FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/user-service*.jar user-service.jar
EXPOSE 8081
#CMD ["java" , "-jar" , "user-service.jar"]
copy wait.sh .
run chmod +x wait.sh
CMD ["./wait.sh"]