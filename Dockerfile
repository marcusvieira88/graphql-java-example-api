FROM mherwig/alpine-java-mongo
MAINTAINER Marcus Vieira <marcusvinicius.vieira88@gmail.com>

# Install Maven
ENV MAVEN_VERSION 3.5.4
ENV MAVEN_HOME /usr/lib/mvn
ENV PATH $MAVEN_HOME/bin:$PATH
RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
  mv apache-maven-$MAVEN_VERSION /usr/lib/mvn

# Copy our source to directory
COPY pom.xml /tmp/
COPY src /tmp/src/
# Path where docker will run the commands - default is / (root)
WORKDIR /tmp/
# Install app dependencies (Java project)
RUN mvn package
# Start database(background) and app server
CMD mongod  --fork --syslog && mvn jetty:run
