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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {
    private LoginService testInstance;

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
        testInstance = new LoginService(mockedDAO);

        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockedDAO.selectUserByUsername("SuperRandomMan")).thenReturn(testUser);
    }

    @Test
    @Order(1)
    public void testLoginSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.userLogin("SuperRandomMan", "ItThatShallNotBeGuessed"));
    }

    @Test
    @Order(2)
    public void testLoginWrongUsername() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperPredictableMan", "ItThatShallNotBeGuessed"));
    }

    @Test
    @Order(3)
    public void testLoginWrongPassword() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperRandomMan", "Password"));
    }

    @Test
    @Order(4)
    public void testLoginWrongEverything() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperPredictableMan", "Password"));
    }

}
