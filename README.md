# ScottishPower Java Technical Test Solution

## Notes

### Testing

The tests are currently using the live H2 database which is fine for now as we are only using it as a dummy database anyway. Once we connect to the real database, the H2 database will only be used for testing to avoid hitting the live database.

### Security

This kind of endpoints would normally be secured. However since we are still in the development phase, they are open to anyone, as is the H2 web interface.

## Launching the Application

### IDE

#### Lombok

This project uses Lombok to handle POJO boilerplate.

In order to compile from an IDE, you'll need to install the Lombok plugin otherwise you'll get errors in the MeterRead class. Details on how to do this are available [here](https://www.baeldung.com/lombok-ide).

#### Running

Add a Spring Boot run configuration with main class
> uk.co.scottishpower.techtest.TechTestApplication

and run it. No extra configuraton needed.

### Maven

A [maven wrapper](https://github.com/takari/maven-wrapper) is bundled with the application so you don't need to have it installed.

You can of course use an existing maven installation, in which case you'd use mvn instead of ./mvnw in the below commands.

#### JDK

You need to have JAVA_HOME set in your environment and pointing to a Java JDK >= 1.8.

#### Building

Go to the tech-test folder in your terminal and run:
> ./mvnw clean install

#### Running

Run this command in the tech-test folder to bring up the application:
> ./mvnw spring-boot:run

## Using the Application

### REST Endpoint

The endpoint to retrieve a reading is available at:
> http://localhost:8080/api/smart/reads/{ACCOUNTNUMBER}

### Swagger

I've also enabled Swagger to make it easy to understand and interact with the REST endpoints. This is available at:
> http://localhost:8080/swagger-ui.html

### H2 Web Interface

In order to provide easy access to the data that is available, I've enabled the H2 web interface which is located at:
> http://localhost:8080/h2-console

The default credentials have not been changed so all you need to do to access it is update the JDBC URL to
> jdbc:h2:mem:testdb

and click Connect.

Once in there you can use
> SELECT * FROM METER_READ

to view the meter readings. For convenience, I have loaded 100 meter readings generated using [Mockaroo](https://mockaroo.com).

You can also use this to view the the table schema:
> SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'METER_READ'