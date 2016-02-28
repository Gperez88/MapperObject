# MapperObject
Object mapping example

### Sample

**source object**

```java
public class User {
    private int id;
    private String name;
    private String password;
    private Persona persona;
    private List<Role> roles;

    // implementation assumes the getters and setters.
    
}
```

**Destination Object**

``` java
@EntityMapper
public class UserDto{
    @Mapping
    private int id;
    @Mapping(name = "name")
    private String username;
    @Mapping
    private String password;
    @Mapping(name = "persona",otherType = true)
    private PersonaDto personaDto;
    @Mapping(name = "roles", otherType = true)
    private List<RoleDto> rolesDto;

    // implementation assumes the getters and setters.

}
```

**Implement**

``` java
public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setFirstname("Gabriel");
        persona.setLastname("Perez");

        Role role1 = new Role();
        role1.setName("role1");

        Role role2 = new Role();
        role2.setName("role2");

        Role role3 = new Role();
        role3.setName("role3");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        User user = new User();
        user.setId(1);
        user.setName("gaperez");
        user.setPassword("Password123");
        user.setPersona(persona);
        user.setRoles(roles);

        // mapper objects
        UserDto userDto = Mapper.map(user, UserDto.class);

        System.out.println("*************************");
        System.out.println("**********USER***********");
        System.out.println("*************************");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getPersona().getFirstname());
        System.out.println(user.getPersona().getLastname());
        for (Role role : user.getRoles()) {
            System.out.println(role.getName());
        }
        System.out.println("*************************");
        System.out.println("*********USERDTO*********");
        System.out.println("*************************");
        System.out.println(userDto.getId());
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getPassword());
        System.out.println(userDto.getPersonaDto().getFirstname());
        System.out.println(userDto.getPersonaDto().getLastname());
        for (RoleDto roleDto : userDto.getRolesDto()) {
            System.out.println(roleDto.getRolename());
        }
    }
}
```
