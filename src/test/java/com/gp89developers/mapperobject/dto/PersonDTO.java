package com.gp89developers.mapperobject.dto;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.gp89developers.mapperobject.entity.PersonEntity;

/**
 * Created by gaperez on 4/29/2016.
 */

@EntityMapper
public class PersonDTO extends ParsableObject<PersonEntity,PersonDTO>{
    @Mapping
    private int id;
    @Mapping
    private String firstname;
    @Mapping
    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public Class<PersonEntity> getDomainClass() {
        return PersonEntity.class;
    }
}
