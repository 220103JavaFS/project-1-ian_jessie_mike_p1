package com.revature.service;

import com.revature.dao.Reimbursement_DAO_IMP;
import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReimbursementServiceTest {
    private ReimbursementService testInstance;
    private static String resolveTime="2018-09-01 09:01:15";
    private static String authorTime = "2017-09-01 09:01:15";
    @Mock
    private Reimbursement_DAO_IMP mockedDAO;
    private Reimbursement testReimbursement = new Reimbursement();

    @BeforeEach
    public void setUp() throws NoSuchAlgorithmException {
        //Creating the reimbursement

        Timestamp time = new Timestamp(2022, 1, 29, 17, 32, 30, 30);

        testReimbursement.setReimbursement_ID(10);
        testReimbursement.setReimbursement_Amount(100.00F);
        testReimbursement.setTime_Submitted(authorTime);
        testReimbursement.setTime_Resolved(resolveTime);
        testReimbursement.setDescription("The flight was too long");
        testReimbursement.setAuthor_ID(3);
        testReimbursement.setResolver_ID(6);
        testReimbursement.setStatus_ID(1);
        testReimbursement.setType_ID(4);

        //Tells Mockito to scan for any Mock objects
        MockitoAnnotations.openMocks(this);

        //Create reimbursement service with the mock reimbursementDao

        testInstance = new ReimbursementService(mockedDAO);

        List<Reimbursement> lst = new ArrayList<Reimbursement>() {{
            add(testReimbursement);
        } };

        //when userDao object calls selectUserByUsername during the login function, return the test user created above.
        Mockito.when(mockedDAO.select_All_Reimbursements()).thenReturn(lst);
        Mockito.when(mockedDAO.select_All_Reimbursements_By_Author_ID(3)).thenReturn(lst);
        Mockito.when(mockedDAO.select_All_Reimbursement_By_Status_ID(1)).thenReturn(lst);
        Mockito.when(mockedDAO.select_Reimbursement_By_ID(10)).thenReturn(testReimbursement);
        Mockito.when(mockedDAO.insert(testReimbursement)).thenReturn(true);
        Mockito.when(mockedDAO.update(testReimbursement)).thenReturn(true);
    }
    //=========================================================================================
    //public boolean insertReimbursement(Reimbursement newReimbursement){
    //      return serviceReimbursement.insert(newReimbursement);
    // }

    @Test
    @Order(1)
    public void testInsertReimbursementSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.insertReimbursement(testReimbursement));
    }

    //=================================================================================
    //public boolean updateReimbursement(Reimbursement newReimbursement){
    //      return serviceReimbursement.update(newReimbursement);
    //}

    @Test
    @Order(2)
    public void testUpdateReimbursementSuccess() throws NoSuchAlgorithmException {
        assertTrue(testInstance.updateReimbursement(testReimbursement));
    }

    //=================================================================================
    //public Reimbursement selectReimbursementByID(Integer id){
    //      return serviceReimbursement.select_Reimbursement_By_ID(id);
    // }

    @Test
    @Order(3)
    public void testSelectReimbursementByIDSuccess() throws NoSuchAlgorithmException {
        assertEquals(testReimbursement, testInstance.selectReimbursementByID(10));
    }

    @Test
    @Order(4)
    public void testSelectUserByIDWrongID() throws NoSuchAlgorithmException {
        assertNull(testInstance.selectReimbursementByID(2));
    }

    //=================================================================================
    //public List<Reimbursement> selectAllReimbursements(){
    //      return serviceReimbursement.select_All_Reimbursements();
    // }

    @Test
    @Order(5)
    public void testSelectAllReimbursementsSuccess() throws NoSuchAlgorithmException {
        List<Reimbursement> lst = new ArrayList<Reimbursement>() {{
            add(testReimbursement);
        } };
        assertEquals(lst, testInstance.selectAllReimbursements());
    }

    //=================================================================================
    //public List<Reimbursement> selectAllReimbursementsByAuthorID(Integer id){
    //      return serviceReimbursement.select_All_Reimbursements_By_Author_ID(id);
    // }

    @Test
    @Order(6)
    public void testSelectAllReimbursementsByAuthorIDSuccess() throws NoSuchAlgorithmException {
        List<Reimbursement> lst = new ArrayList<Reimbursement>() {{
            add(testReimbursement);
        } };
        assertEquals(lst, testInstance.selectAllReimbursementsByAuthorID(3));
    }

    //=================================================================================
    //public List<Reimbursement> selectAllReimbursementByStatusID(Integer id){
    //      return serviceReimbursement.select_All_Reimbursement_By_Status_ID(id);
    // }

    @Test
    @Order(7)
    public void testSelectAllReimbursementsByStatusIDSuccess() throws NoSuchAlgorithmException {
        List<Reimbursement> lst = new ArrayList<Reimbursement>() {{
            add(testReimbursement);
        } };
        assertEquals(lst, testInstance.selectAllReimbursementByStatusID(1));
    }
}
