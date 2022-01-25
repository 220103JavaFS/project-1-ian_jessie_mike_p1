package com.revature.dao;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;

public class Reimbursement_DAO_IMPTest {

    private static Reimbursement_DAO_IMP reimbursementDAO;
    private static Reimbursement reimbursement = new Reimbursement();

    @BeforeEach
    public void setup(){
        float amount = 3.50F;
        String resolveTime="2018-09-01 09:01:15";
        String authorTime = "2017-09-01 09:01:15";
        Timestamp timestamp= Timestamp.valueOf(resolveTime);
        Timestamp timestamp2= Timestamp.valueOf(authorTime);
        reimbursement.setReimbursement_ID(1);
        reimbursement.setReimbursement_Amount(amount);
        reimbursement.setAuthor_ID(1);
        reimbursement.setResolver_ID(2);
        reimbursement.setTime_Resolved(timestamp);
        reimbursement.setTime_Submitted(timestamp2);
        reimbursement.setStatus_ID(1);
        reimbursement.setType_ID(1);
        reimbursement.setDescription("This is a practice description");
        reimbursement.setReciept(null);
    }

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


    /*Tests
    * Create reimbursment ticket
    * */

}
