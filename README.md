# Introduction

This is a GraphQl API implemented in Java, , it is used as example in my blog (https://marcusvieira.tech) tutorials.

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

## Api

### Graphql URL

http://localhost:8080/graphql-api

#### Mutations

<p>createUser</p>
<p>createMessage</p>

#### Queries Objects

###### User
<p>id</p>
<p>name</p>
<p>email</p>

###### Message
<p>id</p>
<p>createdAt</p>
<p>message</p>
<p>userId</p>
<p>user : User</p>



