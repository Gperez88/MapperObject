package repository;

import mapper.EntityMapper;
import mapper.Mapping;
import mapper.Parsable;
import model.Role;

/**
 * Created by Gaperez on 8/5/2015.
 */
@EntityMapper
public class RoleDto extends Parsable<Role,RoleDto> {
    @Mapping(name = "name")
    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public Class<Role> getDomainClass() {
        return Role.class;
    }
}
