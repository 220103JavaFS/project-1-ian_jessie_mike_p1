package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.Reimbursement_Type;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class reimbursementTypeDAOIMPTest {

    private static String resolveTime="2018-09-01 09:01:15";
    private static String authorTime = "2017-09-01 09:01:15";
    private static Timestamp timestamp= Timestamp.valueOf(resolveTime);
    private static Timestamp timestamp2= Timestamp.valueOf(authorTime);
    private static byte[] bytes = {55,22};

    private static IReimbursement_Type_DAO reimbursement_type_dao = new Reimbursement_Type_DAO_IMP();

    private static Reimbursement reimbursement = new Reimbursement(
            1,3.50F, authorTime, resolveTime, "Practice Description", null,1,1,1,1);
    private static Reimbursement reimbursement2 = new Reimbursement(
            2,3.50F, authorTime, resolveTime, "Practice Description", null,1,1,1,2);
    private static Reimbursement_Type reimbursement_type = new Reimbursement_Type(1,"lodging");

    @Test
    void selectReimbursementTypeTest() {
        assertEquals(reimbursement_type.getReimbursement_Type(), reimbursement_type_dao.selectReimbursementTypeByID(reimbursement.getType_ID()));
    }

    @Test
    void selectInvalidReimbursementTypeTest(){
        assertNotEquals(reimbursement_type.getReimbursement_Type(), reimbursement_type_dao.selectReimbursementTypeByID(reimbursement2.getType_ID()));
    }


}
