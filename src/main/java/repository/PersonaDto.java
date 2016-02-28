package repository;

import mapper.EntityMapper;
import mapper.Mapping;

/**
 * Created by gabriel on 8/5/2015.
 */
@EntityMapper
public class PersonaDto {
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
}
