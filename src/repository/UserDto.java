package repository;

import mapper.Mapping;
import model.Role;

import java.util.List;

/**
 * Created by Gaperez on 8/5/2015.
 */
public class UserDto {
    @Mapping(name = "name")
    private String username;
    @Mapping
    private String password;
    @Mapping(name = "persona",otherType = true)
    private PersonaDto personaDto;
    @Mapping(name = "roles", iterable = true)
    private List<RoleDto> rolesDto;

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
}
