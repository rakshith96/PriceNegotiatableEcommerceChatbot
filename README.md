# PriceNegotiatableEcommerceChatbot

Install maven
https://www.mkyong.com/maven/how-to-install-maven-in-windows/

Install JDK
Install Spring Tool Suite
https://spring.io/tools/sts/all
(You just need to download the right file wrt your OS and extract the files)

Install PostgreSQL 10
check the option to install PGAdmin while install, it has a good interface to view database, also check the option of psql command shell

Create a database called myData in Postgres and make corresponding changes in application.properties file under the directory "PriceNegotiatableEcommerceChatbot\src\main\resources"

Open command prompt in PriceNegotiatableEcommerceChatbot directory and run the following commands
	mvn clean
	mvn install
	mvn spring-boot:run

Open your browser and enter the URL "http://localhost:8080/welcome"

If you can see the "Welcome" message you are successfully running the BackendJavaAPI.