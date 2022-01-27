package com.revature.dao;

import com.revature.models.Users;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Users_DAO_IMPTest {

    private static Users_DAO_IMP userdao = new Users_DAO_IMP();
    private static Users user = new Users(0,"UserMike", "PASSWORD", "Mike", "Ludwig", "mluddy@email.com", 1);

//    @Test
//    void createUser(){assertTrue(userdao.insert(user));}
//
//    @Test
//    void updateUser(){assertTrue(userdao.update(user));}

    @Test
    void selectUserByUsername(){assertEquals(user, userdao.selectUserByUsername(user.getUser_Name()));}

    @Test
    void selectUserByID(){assertEquals(user,userdao.selectUserByID(user.getUser_ID()));}

}
