import mapper.Mapper;
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

        Role role = new Role();
        role.setName("admin");

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        User user = new User();
        user.setId(1);
        user.setName("gaperez");
        user.setPassword("Password123");
        user.setPersona(persona);
        user.setRoles(roles);

        //TODO: collection mapper coming soon :P
        List<RoleDto> rolesDto = new ArrayList<>();
        for(Role roleSource: roles){
            RoleDto roleDto = Mapper.map(roleSource,RoleDto.class);
            rolesDto.add(roleDto);
        }

        UserDto userDto = Mapper.map(user, UserDto.class);
        userDto.setRolesDto(rolesDto);

        System.out.println("*************************");
        System.out.println("**********USER***********");
        System.out.println("*************************");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getPersona().getFirstname());
        System.out.println(user.getPersona().getLastname());
        System.out.println(user.getRoles().get(0).getName());
        System.out.println("*************************");
        System.out.println("*********USERDTO*********");
        System.out.println("*************************");
        System.out.println(userDto.getId());
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getPassword());
        System.out.println(userDto.getPersonaDto().getFirstname());
        System.out.println(userDto.getPersonaDto().getLastname());
        System.out.println(userDto.getRolesDto().get(0).getRolename());
    }
}
