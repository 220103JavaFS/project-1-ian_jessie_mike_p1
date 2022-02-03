package com.revature.service;

import com.revature.dao.Reimbursement_Status_DAO_IMP;
import com.revature.models.Reimbursement_Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReimbursementStatusServiceTest {
    private ReimbursementStatusService testInstance;

    @Mock
    private Reimbursement_Status_DAO_IMP mockedDAO;
    private Reimbursement_Status testStatus = new Reimbursement_Status();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        testStatus.setStatus_ID(1);
        testStatus.setStatus("Pending");

        //Tells Mockito to scan for any Mock objects
        MockitoAnnotations.openMocks(this);

        //Create login service with the mock userDao
        testInstance = new ReimbursementStatusService(mockedDAO);

        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockedDAO.selectReimbursementStatusByID(1)).thenReturn(testStatus.getStatus());
    }

    @Test
    @Order(1)
    public void testSelectStatusByIDSuccess() throws NoSuchAlgorithmException {
        assertEquals(testStatus.getStatus(), testInstance.selectReimbursementStatusByID(1));
    }

    @Test
    @Order(2)
    public void testSelectStatusByIDWrongID() throws NoSuchAlgorithmException {
        assertNull(testInstance.selectReimbursementStatusByID(5));
    }
}
