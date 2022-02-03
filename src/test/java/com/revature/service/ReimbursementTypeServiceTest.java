package com.revature.service;

import com.revature.dao.Reimbursement_Type_DAO_IMP;
import com.revature.models.Reimbursement_Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReimbursementTypeServiceTest {
    private ReimbursementTypeService testInstance;

    @Mock
    private Reimbursement_Type_DAO_IMP mockedDAO;
    private Reimbursement_Type testType = new Reimbursement_Type();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        testType.setType_ID(1);
        testType.setReimbursement_Type("Lodging");

        //Tells Mockito to scan for any Mock objects
        MockitoAnnotations.openMocks(this);

        //Create login service with the mock userDao
        testInstance = new ReimbursementTypeService(mockedDAO);

        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockedDAO.selectReimbursementTypeByID(1)).thenReturn(testType.getReimbursement_Type());
    }

    @Test
    @Order(1)
    public void testSelectTypeByIDSuccess() throws NoSuchAlgorithmException {
        assertEquals(testType.getReimbursement_Type(), testInstance.selectReimbursementTypeByID(1));
    }

    @Test
    @Order(2)
    public void testSelectTypeByIDWrongID() throws NoSuchAlgorithmException {
        assertNull(testInstance.selectReimbursementTypeByID(5));
    }
}
