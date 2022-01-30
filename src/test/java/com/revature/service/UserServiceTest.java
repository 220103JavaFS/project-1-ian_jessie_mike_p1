package com.revature.service;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.utils.Encryptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService testInstance;

    @Mock
    private Users_DAO_IMP mockedDAO;
    private Users testUser = new Users();
    private Encryptor encryptor = new Encryptor();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        //Creating the testuser
        testUser.setUser_ID(4);
        testUser.setUser_First_Name("random");
        testUser.setUser_Last_Name("man");
        testUser.setUser_Name("SuperRandomMan");
        testUser.setUser_Pass(encryptor.encoder("ItThatShallNotBeGuessed"));
        testUser.setUser_Email("rando@anywhere.com");
        testUser.setUser_Role_ID(1);

        //Tells Mockito to scan for any Mock objects
        MockitoAnnotations.openMocks(this);

        //Create login service with the mock userDao
        testInstance = new UserService(mockedDAO);



        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockedDAO.selectUserByUsername("SuperRandomMan")).thenReturn(testUser);
        Mockito.when(mockedDAO.selectUserByID(4)).thenReturn(testUser);
        Mockito.when(mockedDAO.insert(testUser)).thenReturn(true);
        Mockito.when(mockedDAO.update(testUser)).thenReturn(true);
    }

    //=======================================================================================
    //Users selectUserByUsername(String username){return users_dao.selectUserByUsername(username);}

    @Test
    @Order(1)
    public void testSelectUserByUsernameSuccess() throws NoSuchAlgorithmException {
        assertEquals(testUser, testInstance.selectUserByUsername("SuperRandomMan"));
    }

    @Test
    @Order(2)
    public void testSelectUserByUsernameWrongUsername() throws NoSuchAlgorithmException {
        assertNull(testInstance.selectUserByUsername("SuperPredictableMan"));
    }

    //=========================================================================================

    //Users selectUserByID(int id){return users_dao.selectUserByID(id);}

    @Test
    @Order(3)
    public void testSelectUserByIDSuccess() throws NoSuchAlgorithmException {
        assertEquals(testUser, testInstance.selectUserByID(4));
    }

    @Test
    @Order(4)
    public void testSelectUserByIDWrongID() throws NoSuchAlgorithmException {
        assertNull(testInstance.selectUserByID(2));
    }

    //=======================================================================
//    boolean insertUser(Users users) {
//        if (validateEmail(users.getUser_Email()) &&
//                users.getUser_Name().length() >= MINIMUM_NAME_LENGTH &&
//                users.getUser_Pass().length() >= MINIMUM_PASSWORD_LENGTH &&
//                users.getUser_Name().length() <= MAXIMUM_NAME_LENGTH &&
//                users.getUser_Pass().length() <= MAXIMUM_PASSWORD_LENGTH &&
//                (users.getUser_Role_ID() == EMPLOYEE_ROLE || users.getUser_Role_ID() == MANAGER_ROLE)) {
//            return users_dao.insert(users);
//        }
//        return false;
//    }

    @Test
    @Order(5)
    public void testInsertUserSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.insertUser(testUser));
    }

    @Test
    @Order(6)
    public void testInsertUserInvalidInput() throws NoSuchAlgorithmException {
        testUser.setUser_Email("NotAnEmail");
        assertFalse(testInstance.insertUser(testUser));
    }

    //================================================================================
//    boolean updateUser(Users users) {
//        if (validateEmail(users.getUser_Email()) &&
//                users.getUser_Name().length() >= MINIMUM_NAME_LENGTH &&
//                users.getUser_Pass().length() >= MINIMUM_PASSWORD_LENGTH &&
//                users.getUser_Name().length() <= MAXIMUM_NAME_LENGTH &&
//                users.getUser_Pass().length() <= MAXIMUM_PASSWORD_LENGTH &&
//                (users.getUser_Role_ID() == EMPLOYEE_ROLE || users.getUser_Role_ID() == MANAGER_ROLE)) {
//            return users_dao.update(users);
//        }
//        return false;
//    }

    @Test
    @Order(7)
    public void testUpdateUserSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.updateUser(testUser));
    }

    @Test
    @Order(8)
    public void testUpdateUserInvalidInput() throws NoSuchAlgorithmException {
        testUser.setUser_Email("NotAnEmail");
        assertFalse(testInstance.updateUser(testUser));
    }
}
