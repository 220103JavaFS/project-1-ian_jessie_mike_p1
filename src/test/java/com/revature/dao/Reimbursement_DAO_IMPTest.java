package com.revature.dao;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;

public class Reimbursement_DAO_IMPTest {


    private static String resolveTime="2018-09-01 09:01:15";
    private static String authorTime = "2017-09-01 09:01:15";
    private static Timestamp timestamp= Timestamp.valueOf(resolveTime);
    private static Timestamp timestamp2= Timestamp.valueOf(authorTime);
    private static byte[] bytes = {55,22};

    private static IReimbursement_DAO reimbursementDAO = new Reimbursement_DAO_IMP();


    private static Reimbursement reimbursement = new Reimbursement(
            1,3.50F, timestamp, timestamp2, "Practice Description", null,1,1,1,1);

    //Test general reimbursement creation
    @Test
    void createReimbursement(){
        assertTrue(reimbursementDAO.insert(reimbursement));
    }

    //Test general reimbursement update
    @Test
    void updateReimbursement(){
        assertTrue(reimbursementDAO.update(reimbursement));
    }

    //Test general select reimbursement by id
    @Test
    void selectReimbursement_By_ID(){
        assertEquals(reimbursement, reimbursementDAO.select_Reimbursement_By_ID(reimbursement.getReimbursement_ID()));
    }
}
