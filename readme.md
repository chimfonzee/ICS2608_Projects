# ICS2608 Sample Code
# Download the Project

```
git clone https://github.com/chimfonzee/ICS2608_Projects.git
```
or
```
git clone git@github.com:chimfonzee/ICS2608_Projects.git
```

# Download the Code

!(How to Download Git Project)[resources/screenshot.png]

# Check Versions
- Project is using the following:
  - Glassfish 6
  - Jakarta EE 9
  - Java 8
## Change to corresponding versions installed in your machines
### `web.xml`
Original:
- depends on the project
Change Into:
- comment included in the `web.xml`
- examples exist in the internet
  - Google Search: `web xml version x`
### Servlet
Original
```java
import jakarta.servlet.RequestDispatcher
```
Change Into:
```java
import javax.servlet.RequestDispatcher
```
### `pom.xml`
Original:
```xml
...
<dependency>
  <groupId>jakarta.platform</groupId>
  <artifactId>jakarta.jakartaee-api</artifactId>
  <version>9.0.0</version>
</dependency>
...
```
Change Into (Minimum Version):
```xml
...
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>javax.servlet-api</artifactId>
  <version>3.1.0</version>
  <scope>provided</scope>
</dependency>
...
```

# Run Code
- Import into NetBeans
- Use Maven + Glassfish
  - `mvn clean` -> cleans the archived files
  - `mvn install` or `mvn package` -> creates `.war` file
  - Within the Glassfish dir:
    - `bin/asadmin` -> runs Glassfish server
    - Within the Glassfish CLI (`bin/asadmin`):
      - `deploy --port <port> --host localhost <war_path>`