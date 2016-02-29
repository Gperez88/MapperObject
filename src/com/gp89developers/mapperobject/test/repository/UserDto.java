package com.gp89developers.mapperobject.test.repository;

import com.gp89developers.mapperobject.mapper.EntityMapper;
import com.gp89developers.mapperobject.mapper.Mapping;
import com.gp89developers.mapperobject.mapper.Parsable;
import com.gp89developers.mapperobject.test.model.User;

import java.util.List;

/**
 * Created by Gaperez on 8/5/2015.
 */
@EntityMapper
public class UserDto extends Parsable<User, UserDto> {
    @Mapping
    private int id;
    @Mapping(name = "name")
    private String username;
    @Mapping
    private String password;
    @Mapping(name = "persona", otherType = true)
    private PersonaDto personaDto;
    @Mapping(name = "roles", otherType = true)
    private List<RoleDto> rolesDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonaDto getPersonaDto() {
        return personaDto;
    }

    public void setPersonaDto(PersonaDto personaDto) {
        this.personaDto = personaDto;
    }

    public List<RoleDto> getRolesDto() {
        return rolesDto;
    }

    public void setRolesDto(List<RoleDto> rolesDto) {
        this.rolesDto = rolesDto;
    }

    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }
}
