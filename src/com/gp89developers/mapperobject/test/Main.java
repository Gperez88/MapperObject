package com.gp89developers.mapperobject.test;

import com.gp89developers.mapperobject.test.model.Persona;
import com.gp89developers.mapperobject.test.model.Role;
import com.gp89developers.mapperobject.test.model.User;
import com.gp89developers.mapperobject.test.repository.RoleDto;
import com.gp89developers.mapperobject.test.repository.UserDto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setFirstname("Jose");
        persona.setLastname("Lopez");

        List<Role> roles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            roles.add(new Role("role " + i));
        }

        User user = new User();
        user.setId(1);
        user.setName("jlopez");
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
        for (RoleDto roleDto : rolesDtoFromDomain) {
            System.out.println(roleDto.getRolename());
        }
    }
}
