package repository;

import mapper.EntityMapper;
import mapper.Mapping;

/**
 * Created by Gaperez on 8/5/2015.
 */
@EntityMapper
public class RoleDto {
    @Mapping(name = "name")
    private String rolename;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
