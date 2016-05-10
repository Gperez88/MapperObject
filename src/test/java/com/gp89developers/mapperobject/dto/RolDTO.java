package com.gp89developers.mapperobject.dto;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.gp89developers.mapperobject.entity.RolEntity;

/**
 * Created by gaperez on 4/29/2016.
 */

@EntityMapper
public class RolDTO extends ParsableObject<RolEntity, RolDTO> {
    @Mapping
    private int id;
    @Mapping(name = "name")
    private String rolName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Override
    public Class<RolEntity> getDomainClass() {
        return RolEntity.class;
    }
}
