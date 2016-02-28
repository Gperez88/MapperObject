import model.Persona;
import model.Role;
import model.User;
import repository.RoleDto;
import repository.UserDto;

import java.util.ArrayList;
import java.util.List;

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

        UserDto userDto = new UserDto().load(user);

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

        System.out.println("***************************************");
        System.out.println("*********DOMAIN LIST FROM DTO**********");
        System.out.println("***************************************");
        List<Role> rolesFromDto = new RoleDto().getDomainList(userDto.getRolesDto());
        for (Role role : rolesFromDto) {
            System.out.println(role.getName());
        }

        System.out.println("***************************************");
        System.out.println("*********DTO LIST FROM DOMAIN**********");
        System.out.println("***************************************");
        List<RoleDto> rolesDtoFromDomain = new RoleDto().getViewList(rolesFromDto);
        for (Role role : rolesFromDto) {
            System.out.println(role.getName());
        }
    }
}
