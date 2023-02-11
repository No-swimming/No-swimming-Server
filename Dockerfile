FROM eclipse-temurin:17-jre-focal

COPY build/libs/*.jar /app.jar

ARG DB_URL
ENV DB_URL ${DB_URL}

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
