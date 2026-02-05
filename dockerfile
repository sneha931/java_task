FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Give execute permission
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

# Rename jar to app.jar (VERY IMPORTANT)
RUN mv target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
