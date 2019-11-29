#### Springboot + JPA + CRUD + Service + Transaction
#### Login, Logout, Join, Role, Intercepter, FileUpload

#### 사용자 생성 및 권한 주기 및 DB 생성
- create user 'ssar'@'%' identified by 'bitc5600';
- GRANT ALL PRIVILEGES ON *.* TO 'ssar'@'%';
- create database ssar;
- use ssar;

```yml
server:
  port: 8080
  servlet:
    context-path: /
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssar?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: ssar
    password: bitc5600
    
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      use-new-id-generator-mappings: false
    show-sql: true
    properties:
      hibernate.enable_lazy_load_no_trans: true  
      hibernate.format_sql: true

  http:
    encoding:
      charset: UTF-8
      enabled: true
      force: true
      
      
  servlet:
    multipart:
      enabled: true
      max-file-size: 1MB

file:
  path: C:/src/springWork/jpa-crud/src/main/resources/upload/
  
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.1.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.cos</groupId>
	<artifactId>jpa-crud</artifactId>
	<version>0.1</version>
	<name>jpa-crud</name>
	<description>Spring crud Project</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper</artifactId>
			<version>9.0.22</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```
