package com.revature.service;

import com.revature.dao.Users_DAO_IMP;
import com.revature.models.Users;
import com.revature.utils.Encryptor;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp(){
        testUser.setUser_ID(4);
        testUser.setUser_First_Name("random");
        testUser.setUser_Last_Name("man");
        testUser.setUser_Name("SuperRandomMan");
        testUser.setUser_Pass("ItThatShallNotBeGuessed");
        testUser.setUser_Email("rando@anywhere.com");
        testUser.setUser_Role_ID(77);
        MockitoAnnotations.openMocks(this);

        Encryptor encryptor = new Encryptor();
        testInstance = new LoginService(encryptor, mockedDAO);
        Mockito.when(mockedDAO.selectUserByUsername("SuperRandomMan")).thenReturn(testUser);
    }

    //I don't know if those "throws" do anything in this context, but I figure that they're better than brick code

    @Test
    public void testLoginSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.userLogin("SuperRandomMan", "ItThatShallNotBeGuessed"));
    }

    @Test
    public void testLoginWrongUsername() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperPredictableMan", "ItThatShallNotBeGuessed"));
    }

    @Test
    public void testLoginWrongPassword() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperRandomMan", "Password"));
    }

    @Test
    public void testLoginWrongEverything() throws NoSuchAlgorithmException {
        assertFalse(testInstance.userLogin("SuperPredictableMan", "Password"));
    }
}
