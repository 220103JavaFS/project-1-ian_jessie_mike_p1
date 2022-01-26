package com.revature.service;

import com.revature.dao.Reimbursement_DAO_IMP;
import com.revature.dao.Reimbursement_Status_DAO_IMP;
import com.revature.dao.Reimbursement_Type_DAO_IMP;
import com.revature.models.ReimbursementDTO;

import java.util.List;

public class Employee_Service {

    Reimbursement_DAO_IMP request = new Reimbursement_DAO_IMP();
    Reimbursement_Status_DAO_IMP requestStatus = new Reimbursement_Status_DAO_IMP();
    Reimbursement_Type_DAO_IMP requestType = new Reimbursement_Type_DAO_IMP();

    public ReimbursementDTO viewPastTickets(Integer id) {
        ReimbursementDTO result = new ReimbursementDTO();

        result.setRequest(request.findReimbursement(id));
        result.setStatus(requestStatus.findStatus(getStatus_ID.result.getStatus()));
        result.setType(requestType.findType(getType_ID(result.getType())));

        return result;
    }

    public boolean ReimbursementRequest(ReimbursementDTO fullRequest) {
        if (request.addToEverything(fullRequest)) {
            return true;
        } else {
            return false;
        }
    }
}
