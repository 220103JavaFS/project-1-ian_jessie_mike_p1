package com.revature.dao;

import com.revature.models.Users;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class usersDAOIMPTest {

    private static Users_DAO_IMP userdao = new Users_DAO_IMP();
    private static Users user = new Users(1,"userMike", "password", "luke", "skywalker", "darthVader", 1);
    private static Users user2 = new Users(2,"userJoe", "password", "Joe", "Blow", "Dirty1", 1);


    @Test
    void createUser(){assertTrue(userdao.insert(user2));}

    @Test
    void updateUser(){assertTrue(userdao.update(user2));}

    @Test
    void selectUserByUsername(){assertEquals(user, userdao.selectUserByUsername(user.getUser_Name()));}

    @Test
    void selectUserByID(){assertEquals(user,userdao.selectUserByID(user.getUser_ID()));}

}
