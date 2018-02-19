# IoT-Persisters

This project aims to provide different ways to persiste messages in data bases.

So far, it includes console and elasticsearch.

## How to run

    mvn clean package -Dtests.security.manager=false

## How to use

Add in your maven project the reference of the project from github :

First add the following link that will be able to transform the maven relase into a repository

    <repository>
      <id>jitpack.io</id> <!-- Enable to transform a maven release into a repository -->
      <url>https://jitpack.io</url>
    </repository>
       
Add the following dependecy (by changing the version of relase if there is a new one).

    <!-- PERSISTERS DEPENDENCY -->
    <dependency>
      <groupId>com.github.ysennoun</groupId>
      <artifactId>iot-persisters</artifactId>
      <version>1.0</version>
    </dependency>