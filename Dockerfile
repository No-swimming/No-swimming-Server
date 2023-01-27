FROM eclipse-temurin:17-jre-focal

COPY build/libs/*.jar /app.jar

ARG DB_URL
ENV DB_URL ${DB_URL}

ARG DB_USERNAME
ENV DB_USERNAME ${DB_USERNAME}

ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}

ARG SECRET_KEY
ENV SECRET_KEY ${SECRET_KEY}

ARG ACESS_EXP
ENV ACCESS_EXP ${ACCESS_EXP}

ARG GOOGLE_BASE_URL
ENV GOOGLE_BASE_URL ${GOOGLE_BASE_URL}

ARG GOOGLE_CLIENT_ID
ENV GOOGLE_CLIENT_ID ${GOOGLE_CLIENT_ID}

ARG GOOGLE_SECRET
ENV GOOGLE_SECRET ${GOOGLE_SECRET}

ARG GOOGLE_REDIRECT_URI
ENV GOOGLE_REDIRECT_URI ${GOOGLE_REDIRECT_URI}

ARG FIREBASE_PATH
ENV FIREBASE_PATH ${FIREBASE_PATH}

ENV TZ=Asia/Seoulo

ENTRYPOINT ["java","-jar","/app.jar"]