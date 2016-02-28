package repository;

import mapper.EntityMapper;
import mapper.Mapping;
import java.util.List;

/**
 * Created by Gaperez on 8/5/2015.
 */
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
}
