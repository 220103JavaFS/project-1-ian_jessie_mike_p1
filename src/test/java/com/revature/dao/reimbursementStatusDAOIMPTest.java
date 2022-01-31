package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Status;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class reimbursementStatusDAOIMPTest {

    private static String resolveTime="2018-09-01 09:01:15";
    private static String authorTime = "2017-09-01 09:01:15";
    private static Timestamp timestamp= Timestamp.valueOf(resolveTime);
    private static Timestamp timestamp2= Timestamp.valueOf(authorTime);
    private static byte[] bytes = {55,22};

    private static IReimbursement_Status_DAO reimbursement_status_dao = new Reimbursement_Status_DAO_IMP();

    private static Reimbursement reimbursement = new Reimbursement(
            1,3.50F, authorTime, resolveTime, "Practice Description", null,1,1,1,1);
    private static Reimbursement reimbursement2 = new Reimbursement(
            2,3.50F, authorTime, resolveTime, "Practice Description", null,1,1,2,2);
    private static Reimbursement_Status reimbursement_status = new Reimbursement_Status(1,"pending");

    @Test
    void selectReimbursementStatusTest() {
        assertEquals(reimbursement_status.getStatus(), reimbursement_status_dao.selectReimbursementStatusByID(reimbursement.getStatus_ID()));
    }

    @Test
    void selectInvalidReimbursementStatusTest(){
        assertNotEquals(reimbursement_status.getStatus(), reimbursement_status_dao.selectReimbursementStatusByID(reimbursement2.getStatus_ID()));
    }


}
