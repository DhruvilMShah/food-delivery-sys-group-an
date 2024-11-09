To add security to your endpoints in your microservice, follow these steps:

### 1. Add the following dependency in your `pom.xml` file:
```xml
<dependency>
    <groupId>com.group.an</groupId>
    <artifactId>securityLibrary</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 2. Add Security Annotation & Package Scanning for securityLibrary in your Main Class. Example:

```java
@SecurityScheme(name = "jwtAuth", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@SpringBootApplication(scanBasePackages = {"com.group.an.dataLibrary","com.group.an.orderService","com.group.an.securityLibrary"})
public class OrderServiceApplication {
.....
}
```
### 3. Add below annotation on the endpoints you need to secure
```java
@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
```
Refer: OrderController.java class

### 4. To access the userId & role in any of your Service Class, for any further validations, below methods can be used

```java
Integer userId = JwtTokenUtil.getUserIdFromAuthContext();
Role role = JwtTokenUtil.getRoleFromAuthContext();
```

