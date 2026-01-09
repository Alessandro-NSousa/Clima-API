# ===== STAGE 1 - BUILD =====
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && ./mvnw clean package -DskipTests


# ===== STAGE 2 - RUNTIME =====
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/target/*jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

