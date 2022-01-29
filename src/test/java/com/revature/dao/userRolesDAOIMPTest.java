package com.revature.dao;

import com.revature.models.User_Roles;
import com.revature.models.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class userRolesDAOIMPTest {

    private static IUser_Roles_DAO userRolesDAO = new User_Roles_DAO_IMP();
    private static Users user = new Users(1,"userMike", "password", "luke", "skywalker", "darthVader", 1);
    private static Users user2 = new Users(2,"userMike", "password", "luke", "skywalker", "darthVader", 2);
    private static Users badUser= new Users(2,"userMike", "password", "luke", "skywalker", "darthVader", 4);
    private static User_Roles employeeRole = new User_Roles(1, "employee");
    private static User_Roles managerRole = new User_Roles(2, "manager");

    @Test
    void selectEmployeeRoleByIDTest() {
        assertEquals(employeeRole.getUser_Role(), userRolesDAO.selectUserRoleByUserID(user.getUser_ID()));
    }

    @Test
    void selectManagerRoleByIDTest(){
        assertEquals(managerRole.getUser_Role(), userRolesDAO.selectUserRoleByUserID(user2.getUser_ID()));
    }

    //bad user must be added to db to function
//    @Test
//    void selectNonExistingUserRole(){
//        assertNotEquals(employeeRole.getUser_Role(), userRolesDAO.selectUserRoleByUserID(badUser.getUser_ID()));
//    }

}
