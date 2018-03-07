# SpringJPA-Postgresql

參考網址 : http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot

I. Technology
– Jdk 1.8
– Maven 1.8.2.20171007-0217
– Spring IDE 3.9.2.201712210913-RELEASE
– Spring Boot: RELEASE


II. Overview
1. Goal
http://javasampleapproach.com/wp-content/uploads/2016/09/springjpa-postgresql-thegoal.jpg

2. Project Structure
http://javasampleapproach.com/wp-content/uploads/2016/09/springjpa-postgresql-projectstructure.png


III. Practice
1. Create Spring Boot project & add Dependencies
    Open Spring Tool Suite, on Menu, choose File -> New -> Spring Starter Project
    Click Next, in SQL: choose JPA and PostgreSQL, in Web, Click Finish

2. Configure Spring JPA
    Open application.properties
-----
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.username=postgres
spring.datasource.password=111111
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.hbm2ddl.auto=update
-----

3. Use Model @Entity + application.properties to Create Talbe and Update Schema

4. Create Web Controller / Service / Data access object

IV. Run Spring Boot Application
– Config maven build:
clean install
– Run project with mode Spring Boot App
– Check results:

