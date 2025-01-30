FROM eclipse-temurin:17-jdk
COPY target/api-gateway-1.0.0.jar /usr/local/lib/api-gateway.jar
WORKDIR /usr/local/lib
EXPOSE 8080
CMD ["java", "-jar", "api-gateway.jar"]
