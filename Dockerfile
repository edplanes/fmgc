FROM ghcr.io/graalvm/native-image-community:23-muslib AS build

ARG GRADLE_VERSION=8.12

WORKDIR /app

RUN microdnf install -y unzip zip findutils make gcc

RUN curl -LO https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
  unzip gradle-${GRADLE_VERSION}-bin.zip -d /opt && \
  rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME /opt/gradle-${GRADLE_VERSION}
ENV PATH $PATH:/opt/gradle-${GRADLE_VERSION}/bin

COPY . .

RUN mkdir /new_tmp

RUN gradle nativeCompile --no-daemon -x test

FROM scratch

COPY --from=build /new_tmp /tmp
COPY --from=build /app/build/native/nativeCompile/fmgc /fmgc

CMD ["/fmgc"]