package com.revature.service;

import com.revature.dao.IUsers_DAO;
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
    @Mock
    private Users_DAO_IMP mockUser;
    private Users testUser = new Users();
    private LoginService testLoginService;
    private Encryptor encryptor = new Encryptor();

    @BeforeEach
    public void setup() throws NoSuchAlgorithmException {

        //setting users credentials
        testUser.setUser_Name("userMike");
        testUser.setUser_Pass(encryptor.encoder("bigDoggy101"));

        //Tells Mockito to scan for any Mock objects
        MockitoAnnotations.openMocks(this);

        //Create login service with the mock userDao
        testLoginService = new LoginService(mockUser);

        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockUser.selectUserByUsername("userMike")).thenReturn(testUser);
    }

    @Test
    @Order(1)
    public void successfulLoginTest() throws NoSuchAlgorithmException {
        assertTrue(testLoginService.userLogin("userMike", "bigDoggy101"));
    }

    @Test
    @Order(2)
    public void failedPasswordLoginTest() throws NoSuchAlgorithmException {
        assertFalse(testLoginService.userLogin("userMike", "randompassword"));
    }

    @Test
    @Order(3)
    public void failedUsernameLoginTest() throws NoSuchAlgorithmException {
        assertFalse(testLoginService.userLogin("wronguser", "bigDoggy101"));
    }

    @Test
    @Order(4)
    public void failedUsernameAndPasswordLoginTest() throws NoSuchAlgorithmException {
        assertFalse(testLoginService.userLogin("wronguser", "wrongpassword"));
    }

}
