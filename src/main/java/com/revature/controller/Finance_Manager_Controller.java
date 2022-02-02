package com.revature.controller;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.Users;
import com.revature.service.ReimbursementService;
import com.revature.service.ReimbursementStatusService;
import com.revature.service.ReimbursementTypeService;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
* Finance managers can log in and view all reimbursement requests and past history for all employees
* in the company. Finance managers are authorized to approve and deny requests for expense
* reimbursement.
* */

public class Finance_Manager_Controller extends Controller{

    private final UserService userService = new UserService();
    private final ReimbursementService reimbursementService = new ReimbursementService();
    private final ReimbursementTypeService reimbursementTypeService = new ReimbursementTypeService();
    private final ReimbursementStatusService reimbursementStatusService = new ReimbursementStatusService();
    private static final Logger financeControllerLog = LoggerFactory.getLogger(Finance_Manager_Controller.class);

    private Handler viewAllReimbursementRequests = (ctx) -> {
        if (ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("manager")){

            //Initialize reimbursement lists
            List<ReimbursementDTO> dtoList = new ArrayList<>();
            List<Reimbursement> reimbursementList = reimbursementService.selectAllReimbursements();

            //For each reimbursement, build DTO
            for(int i = 0; i <reimbursementList.size(); i++){
                Users author = userService.selectUserByID(reimbursementList.get(i).getAuthor_ID());
                String status = reimbursementStatusService.selectReimbursementStatusByID(reimbursementList.get(i).getStatus_ID());
                String type = reimbursementTypeService.selectReimbursementTypeByID(reimbursementList.get(i).getType_ID());
                ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursementList.get(i),status,type,author);
                dtoList.add(reimbursementDTO);
            }

            ctx.json(dtoList);
            financeControllerLog.info("Manager View All Requests Successful");
            ctx.status(200);
        }else{
            ctx.req.getSession().invalidate();
            ctx.json("Invalid manager session!!");
            financeControllerLog.info("View all reimbursements manager failed!!!");
            ctx.status(401);

        }
    };

    private Handler viewAllRequestsForEmployee = ctx -> {
        if (ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("manager")) {

            //Get path the employee id path parameters
            String id = ctx.pathParam("userID");
            int reimbursementID = Integer.parseInt(id);
            List<ReimbursementDTO> dtoList = new ArrayList<>();

            //Query for all reimbursements associated with employee and build their list
            List<Reimbursement> reimbursementList = reimbursementService.selectAllReimbursementsByAuthorID(reimbursementID);
            for(int i = 0; i <reimbursementList.size(); i++){
                Users author = userService.selectUserByID(reimbursementList.get(i).getAuthor_ID());
                String status = reimbursementStatusService.selectReimbursementStatusByID(reimbursementList.get(i).getStatus_ID());
                String type = reimbursementTypeService.selectReimbursementTypeByID(reimbursementList.get(i).getType_ID());
                ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursementList.get(i),status,type,author);
                dtoList.add(reimbursementDTO);
            }

            ctx.json(dtoList);
            financeControllerLog.info("Manager View All Requests for single employee Successful");
            ctx.status(200);
        }else{
            ctx.req.getSession().invalidate();
            ctx.json("Invalid manager session!!");
            financeControllerLog.info("View all reimbursements manager failed!!!");
            ctx.status(401);
        }
    };

    private Handler filterRequestsByPending = (ctx) -> {
        if (ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("manager")){

            //Get reimbursement status applied from path
            String status = ctx.pathParam("status");
            List<ReimbursementDTO> dtoList = new ArrayList<>();
            List<Reimbursement> reimbursementList;

            //select based on status
            if(status.equals("pending")) {
                reimbursementList = reimbursementService.selectAllPendingReimbursements();
            }else if(status.equals("approved")){
                reimbursementList = reimbursementService.selectAllReimbursementByStatusID(2);
            }else{
                reimbursementList = reimbursementService.selectAllReimbursementByStatusID(3);

            }

            //return list of reimbursements with status
            for(int i = 0; i <reimbursementList.size(); i++){
                Users author = userService.selectUserByID(reimbursementList.get(i).getAuthor_ID());
                String status2 = reimbursementStatusService.selectReimbursementStatusByID(reimbursementList.get(i).getStatus_ID());
                String type = reimbursementTypeService.selectReimbursementTypeByID(reimbursementList.get(i).getType_ID());
                ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursementList.get(i),status2,type,author);
                dtoList.add(reimbursementDTO);
            }
            //return list of reimbursementDTOs
            ctx.json(dtoList);
            financeControllerLog.info("Manager Filter Request Successful");

            ctx.status(200);
        }else{
            ctx.req.getSession().invalidate();
            ctx.json("Invalid manager session!!");
            financeControllerLog.info("Finance manager filter bad request ");
            ctx.status(401);

        }
    };

    private Handler approveDenyRequest = (ctx) -> {
        if(ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("manager")) {

            //get path variables for reimbursement
            String status = ctx.pathParam("status");
            String id = ctx.pathParam("reimbursementID");
            int reimbursementID = Integer.parseInt(id);

            //select reimbursement by specified id
            Reimbursement reimbursement = reimbursementService.selectReimbursementByID(reimbursementID);
            Integer sessionID = (Integer) ctx.req.getSession().getAttribute("user_id");
            reimbursement.setResolver_ID(sessionID);

            //Update reimbursement on status provided
            if(status.equals("approved")) {
                reimbursement.setStatus_ID(2);
            }else {
                reimbursement.setStatus_ID(3);
            }

            reimbursementService.updateReimbursement(reimbursement);
            ctx.json(reimbursement);
        }else{
            ctx.json("Session is invalid!!");
            ctx.redirect("/login", 401);
        }
    };


    private Handler viewSingleRequest = ctx -> {
        if (ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("manager")) {

            //Get reimbursementID from path
            String id = ctx.pathParam("reimbursementID");
            int reimbursementID = Integer.parseInt(id);

            //Select info to build ReimbusementDTO
            Reimbursement reimbursement = reimbursementService.selectReimbursementByID(reimbursementID);
            Users author = userService.selectUserByID(reimbursement.getAuthor_ID());
            String status = reimbursementStatusService.selectReimbursementStatusByID(reimbursement.getStatus_ID());
            String type = reimbursementTypeService.selectReimbursementTypeByID(reimbursement.getType_ID());
            ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursement,status,type,author);

            //Send reimbursement to front end.
            ctx.json(reimbursementDTO);
            financeControllerLog.info("Manager View Single Request Successful");
            ctx.status(200);
        }else{
            ctx.req.getSession().invalidate();
            ctx.json("Invalid manager session!!");
            financeControllerLog.info("View all reimbursements manager failed!!!");
            ctx.status(401);
        }
    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/manager/reimbursements", viewAllReimbursementRequests);
        app.get("/manager/reimbursements/filter/{status}",filterRequestsByPending);
        app.get("/manager/reimbursements/request/{reimbursementID}", viewSingleRequest);
        app.get("/manager/reimbursements/employee/{userID}", viewAllRequestsForEmployee);
        app.post("/manager/reimbursements/request/{reimbursementID}:{status}", approveDenyRequest);
    }
}
