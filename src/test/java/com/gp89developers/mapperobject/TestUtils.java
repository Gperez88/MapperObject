package com.gp89developers.mapperobject;

import com.gp89developers.mapperobject.dto.RolDTO;
import com.gp89developers.mapperobject.dto.UserDTO;
import com.gp89developers.mapperobject.entity.PersonEntity;
import com.gp89developers.mapperobject.entity.RolEntity;
import com.gp89developers.mapperobject.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by gaperez on 4/29/2016.
 */
public class TestUtils {

    public static UserEntity createUserEntity() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1);
        personEntity.setFirstname("Gabriel");
        personEntity.setLastname("Perez");

        List<RolEntity> rolEntities = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            rolEntities.add(new RolEntity(i, "Rol " + i));
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setUsername("gaperez");
        userEntity.setPassword("Humano100");
        userEntity.setPerson(personEntity);
        userEntity.setRoles(rolEntities);

        return userEntity;
    }

    public static void userDataAssertEquals(UserEntity userEntity, UserDTO userDTO) {
        //user
        assertEquals("user.id not equals", userEntity.getId(), userDTO.getId());
        assertEquals("user.username not equals", userEntity.getUsername(), userDTO.getUsername());
        assertEquals("user.password not equals", userEntity.getPassword(), userDTO.getPassword());
        //person
        assertNotNull("user.person null", userDTO.getPerson());
        assertEquals("user.person.id not equals", userEntity.getPerson().getId(), userDTO.getPerson().getId());
        assertEquals("user.person.firstname not equals", userEntity.getPerson().getFirstname(), userDTO.getPerson().getFirstname());
        assertEquals("user.person.lastname not equals", userEntity.getPerson().getLastname(), userDTO.getPerson().getLastname());
        //rol
        assertNotNull("user.roles null", userDTO.getRoleDTOs());
        assertEquals("user.roles.size not equals", userEntity.getRoles().size(), userDTO.getRoleDTOs().size());
        rolesDataAssertEquals(userEntity.getRoles(), userDTO.getRoleDTOs());
    }

    public static void rolesDataAssertEquals(List<RolEntity> rolEntity, List<RolDTO> rolDTOs) {
        for (int i = 0; i < rolEntity.size(); i++) {
            assertEquals("user.roles.id not equals", rolEntity.get(i).getId(), rolDTOs.get(i).getId());
            assertEquals("user.roles.name not equals", rolEntity.get(i).getName(), rolDTOs.get(i).getRolName());
        }
    }
}
