package com.revature.dao;

import com.revature.models.User_Roles;
import com.revature.models.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userRolesDAOIMPTest {

    private static IUser_Roles_DAO userRolesDAO = new User_Roles_DAO_IMP();
    private static Users user = new Users(1,"userMike", "password", "luke", "skywalker", "darthVader", 1);
    private static User_Roles role = new User_Roles(1, "Employee");

    @Test
    void select_User_Role_By_ID() {
        assertEquals(role.getUser_Role(), userRolesDAO.selectUserRoleByUserID(user.getUser_ID()));
    }

}
