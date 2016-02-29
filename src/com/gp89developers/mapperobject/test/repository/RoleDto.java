package com.gp89developers.mapperobject.test.repository;


import com.gp89developers.mapperobject.mapper.EntityMapper;
import com.gp89developers.mapperobject.mapper.Mapping;
import com.gp89developers.mapperobject.mapper.Parsable;
import com.gp89developers.mapperobject.test.model.Role;

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
