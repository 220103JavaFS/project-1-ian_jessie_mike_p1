package com.revature.dao;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;

public class reimbursementDAOIMPTest {


    private static String resolveTime="2018-09-01 09:01:15";
    private static String authorTime = "2017-09-01 09:01:15";
    private static Timestamp timestamp= Timestamp.valueOf(resolveTime);
    private static Timestamp timestamp2= Timestamp.valueOf(authorTime);
    private static byte[] bytes = {55,22};

    private static IReimbursement_DAO reimbursementDAO = new Reimbursement_DAO_IMP();


    private static Reimbursement reimbursement = new Reimbursement(
            1,3.50F, authorTime,resolveTime, "Practice Description", null,1,1,1,1);

    //Test general reimbursement creation
    @Test
    void createReimbursementTest(){
        assertTrue(reimbursementDAO.insert(reimbursement));
    }

    //Test general reimbursement update
    @Test
    void updateReimbursementTest(){
        assertTrue(reimbursementDAO.update(reimbursement));
    }

    //Test general select reimbursement by id
    @Test
    void selectReimbursementByIDTest(){
        assertEquals(reimbursement, reimbursementDAO.select_Reimbursement_By_ID(reimbursement.getReimbursement_ID()));}

    @Test
    void selectAllReimbursementsByAuthorIDTest(){
        assertNotEquals(null,reimbursementDAO.select_All_Reimbursements_By_Author_ID(reimbursement.getAuthor_ID()));
    }

    @Test
    void selectAllReimbursementsTest(){
        assertNotEquals(null, reimbursementDAO.select_All_Reimbursements());
    }

    @Test
    void selectAllReimbursementByStatusIDTest(){
        assertNotEquals(null, reimbursementDAO.select_All_Reimbursement_By_Status_ID(reimbursement.getStatus_ID()));
    }

}
