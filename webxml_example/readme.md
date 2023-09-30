# Example of a Java Web Application using `web.xml`
- Double-check the `web.xml` version
- Change `version` from `5.0` to `2.5` for the safest version (oldest version existing)

### Ways to run it
- Import to NetBeans
  - NetBeans development environment should have GlassFish version
  - Run and Deploy using NetBeans
- Through Maven CLI
  - `mvn install` - create `.war` file for the project
  - `mvn clean` - remove all the archive files (`.class` files) in `/target` folder