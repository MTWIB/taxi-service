# Taxi service
### What is this project all about?
This project implements taxi service, which can be used to manage lists of drivers, cars and manufacturers.
With this application you will be able to:
- insert new drivers/cars/manufacturers into your database
- display the entire list of DB entries
- delete unwanted entries
- add a driver to a car
- authorize as a driver and check out all the cars you've got
### What technologies does this project use?
- Java 11
- MySQL
- JDBC
- Apache Tomcat v. 9.0.50
- JSP
- JSTL
- HTML, CSS
### How do I run this project on my PC?
You'll need following prerequisites:
- [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/features/)
- [Apache Tomcat](https://tomcat.apache.org/download-90.cgi)
- [Java](https://www.oracle.com/java/technologies/downloads/#java11)
- [MySQL](https://dev.mysql.com/downloads/installer/)

After you install all of these, you'll need to:
- configure MySQL database
- start Intellij IDEA
- clone the project from GitHub
- replace the DB URL, username, password and driver variables in taxi.util.ConnectionUtil
- add run/debug configuration to the project (select Tomcat, deploy war-exploded and change context path to "/")
- run the project