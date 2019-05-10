# Introduction

This is a GraphQl API implemented in Java, it is used as example in my [blog tutorials](https://marcusvieira.tech/2018/12/27/how-to-create-queries-in-graphql/).
For run this project you need to install MongoDB or build and run the Docker image.

## Install

```
mvn install
```

## Start

```
mvn jetty:run
```
## For execute the Graphql queries:

```
http://localhost:8080/
```

## For run in environment with Java, MongoDb and Maven intalled, please run:
```
docker build -t <your-docker-hub-account>/java_8-mongodb-maven .
docker run -p 8080:8080 -t <your-docker-hub-account>/java_8-mongodb-maven
```

## Api

### Graphql URL

http://localhost:8080/graphql-api

#### Mutations

<p>createUser</p>
<p>createMessage</p>

#### Queries Objects

**User**
<p>id</p>
<p>name</p>
<p>email</p>

**Message**
<p>id</p>
<p>createdAt</p>
<p>message</p>
<p>userId</p>
<p>user : User</p>



