FROM gradle:6.7-jdk15  AS myGradleBuilder
ENV BUILD_DIR=/kingBuild/
WORKDIR ${BUILD_DIR}
COPY build.gradle settings.gradle ${BUILD_DIR}
COPY src/ ${BUILD_DIR}/src

RUN gradle clean build --no-daemon

RUN echo $(ls -a src/main/java)

FROM openjdk:15.0.2-jdk-slim

RUN mkdir /ScientificCalculatorApp
COPY --from=myGradleBuilder /kingBuild/build/libs/*.jar /ScientificCalculatorApp/SciCal.jar

ENTRYPOINT [ "java","-jar","/ScientificCalculatorApp/SciCal.jar" ]