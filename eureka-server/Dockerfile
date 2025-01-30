FROM eclipse-temurin:17-jdk
COPY target/eureka-server-1.0.0.jar /usr/local/lib/eureka-server.jar
WORKDIR /usr/local/lib
EXPOSE 8761
CMD ["java", "-jar", "eureka-server.jar"]
