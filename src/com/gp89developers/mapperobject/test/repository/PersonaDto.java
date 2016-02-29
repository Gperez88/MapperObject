package com.gp89developers.mapperobject.test.repository;


import com.gp89developers.mapperobject.mapper.EntityMapper;
import com.gp89developers.mapperobject.mapper.Mapping;
import com.gp89developers.mapperobject.mapper.Parsable;
import com.gp89developers.mapperobject.test.model.Persona;

/**
 * Created by gabriel on 8/5/2015.
 */
@EntityMapper
public class PersonaDto extends Parsable<Persona, PersonaDto> {
    @Mapping
    private String firstname;
    @Mapping
    private String lastname;

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
    public Class<Persona> getDomainClass() {
        return Persona.class;
    }
}
