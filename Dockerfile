FROM openjdk:8-jre-alpine
ADD target/ms-admin.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080