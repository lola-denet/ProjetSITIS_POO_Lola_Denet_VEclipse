# Project INF 201 2021

The purpose of this programming project is to produce a program in Java allowing the user to connect to the PMSI database and to make queries there.

You can see the documentation by opening [this file](https://github.com/lola-denet/ProjetSITIS_POO_Lola_Denet/blob/212fa092aa054b80fd8faf4d836631099c457056/doc/index.html) on your web navigator.

## To start

In order to be able to run the program correctly, it is necessary to create the database and load the data into it so that it can be queried. Then, it is possible to directly run the JAR file of the project.

### Installation
To initialize the database, it is possible to use [this file](https://github.com/lola-denet/ProjetSITIS_POO_Lola_Denet/blob/295f93616ac86cb962ee4119dcdcc5c2a586a89b/PMSI_files/bd_projet.sql) in a DBMS (for example MariaDB) which creates the tables and imports the data.
To run the program without using the JAR file, it is necessary to import the MySQL connector (JDBC) in order to be able to connect to the database.
After compiling the source files, all you have to do is run the [Program.class](https://github.com/lola-denet/ProjetSITIS_POO_Lola_Denet/blob/295f93616ac86cb962ee4119dcdcc5c2a586a89b/out/production/ProjetSITIS_POO_Lola_Denet/Program.class) file.

### Execution with the JAR file
From a command line tool :
- Execute [this file](https://github.com/lola-denet/ProjetSITIS_POO_Lola_Denet/blob/212fa092aa054b80fd8faf4d836631099c457056/out/artifacts/ProjetSITIS_POO_Lola_Denet_jar/ProjetSITIS_POO_Lola_Denet.jar) with this command : ```java -jar out/artifacts/ProjetSITIS_POO_Lola_Denet_jar/ProjetSITIS_POO_Lola_Denet.jar```
- And enjoy

## Used tools
- [IntelliJ Idea](https://www.jetbrains.com/fr-fr/idea/)
- [DBeaver](https://dbeaver.io)
- [MariaDB](https://mariadb.com)
- [MySQL connector](https://dev.mysql.com/doc/connector-j/8.0/en/)

## Author
* **Lola Denet** _alias_ [@lola-denet](https://github.com/lola-denet)


