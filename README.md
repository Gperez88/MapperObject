# MapperObject

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/Gperez88/mapperobject/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

## MapperObject is a library that allows you to transfer data between two objects.

It support's :
  - Object to Object data transfer
  - Collection to Collection data transfer

It have two main annotations :
#### At the class level
```java
@EntityMapper
```
#### At the fields level the mapping annotation
```java
@Mapping(name = "roles", otherType = true)
//name is is the field name on the other class
// otherType tells the mapper engine that this field has another mappins inside it.
```
### Usage
if you need to transfer the data in this class to another one
```java
public class UserEntity {
    private int id;
    private String username;
    private String password;
    //getters and setters
}
```
Extend the ParseableObject class like so :
```java
@EntityMapper
public class UserDTO extends ParsableObject<UserEntity,UserDTO>{
    @Mapping
    private int id;
    @Mapping
    private String username;
    @Mapping
    private String password;
    //getters and setters
}
```

Fetch the object that you want
```java
  UserEntity userEntity = UserGateway.findLogInUser();
```
Create an instance of the Mapper
```java
Mapper mapperObject = MapperObject.getInstance();
```

Call map on the mapper object
```java
 UserDTO mapperObjectUserDTO = mapperObject.map(userEntity, UserDTO.class);
```

To transfer from a parseable DTO just call parse on that object
```java
    userEntity = mapperObjectUserDTO.parse();
```

have fun! :neckbeard: