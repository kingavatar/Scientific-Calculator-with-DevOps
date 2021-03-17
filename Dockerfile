FROM openjdk:11.0-jre-slim

RUN mkdir /ScientificCalculatorApp
COPY /build/libs/*.jar /ScientificCalculatorApp/SciCal.jar

ENTRYPOINT [ "java","-jar","/ScientificCalculatorApp/SciCal.jar" ]