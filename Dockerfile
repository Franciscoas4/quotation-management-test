FROM openjdk:11

RUN mkdir app

ARG JAR_FILE

ADD /target/${JAR_FILE} /app/quotation-management.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "quotation-management"]