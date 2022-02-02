package com.revature.controller;

import com.revature.models.*;
import com.revature.service.*;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/*
 * All employees in the company can login and submit
 * requests for reimbursement and view their past tickets
 * and pending requests.
 * */

public class Employee_Controller extends Controller {

    private final UserService userService = new UserService();
    private final ReimbursementService reimbursementService = new ReimbursementService();
    private final ReimbursementTypeService reimbursementTypeService = new ReimbursementTypeService();
    private final ReimbursementStatusService reimbursementStatusService = new ReimbursementStatusService();
    private static final Logger employeeControllerLog = LoggerFactory.getLogger(Employee_Controller.class);

    private Handler employeeHome = ctx -> {
        //If user has a session and is an employee
        if (ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("employee")) {

            //Get User ID for selecting
            Integer sessionID = (Integer) ctx.req.getSession().getAttribute("user_id");
            Users thisUser = userService.selectUserByID(sessionID);
            ctx.json(thisUser);
            ctx.status(200);

            employeeControllerLog.info("Employee " + thisUser.getUser_First_Name() + " " +
                    thisUser.getUser_Last_Name() + " is visiting their homepage");


            //Session validation
        }else {
            employeeControllerLog.info("Employee with invalid session is attempting to visit the homepage");
            ctx.json("Session is invalid!!");
            ctx.redirect("/login", 401);
        }
    };

    //REIMBURSEMENT SERVICE INSERT MUST VALIDATE REQUEST IS PENDING AND HAS NO
    //RESOLVER ID
    private Handler submitRequest = ctx -> {
        if (ctx.req.getSession(false) != null) {
            //Get reimbursement from req and insert
            Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
            //REIMBURSEMENT SERVICE NEEDS INPUT VALIDATION
            if (reimbursementService.insertReimbursement(reimbursement)) {
                ctx.json(reimbursement);
                ctx.status(200);
            } else {
                employeeControllerLog.info("Reimbursement could not be created!!!");
                ctx.status(400);
            }
            //Session validation
        } else {
            ctx.json("Session is invalid!!");
            ctx.redirect("/login", 401);
        }
    };


    private Handler viewPastTickets = ctx -> {
        if(ctx.req.getSession(false) != null && ctx.req.getSession().getAttribute("user_role").equals("employee")) {

            //Get userID session attribute and build list
            Integer id = (Integer) ctx.req.getSession().getAttribute("user_id");
            List<ReimbursementDTO> dtoList = new ArrayList<>();
            List<Reimbursement> reimbursementList = reimbursementService.selectAllReimbursementsByAuthorID(id);

            //Build reimbursementDTO and send
            for(int i = 0; i <reimbursementList.size(); i++){
                Users author = userService.selectUserByID(reimbursementList.get(i).getAuthor_ID());
                String status = reimbursementStatusService.selectReimbursementStatusByID(reimbursementList.get(i).getStatus_ID());
                String type = reimbursementTypeService.selectReimbursementTypeByID(reimbursementList.get(i).getType_ID());
                ReimbursementDTO reimbursementDTO = new ReimbursementDTO(reimbursementList.get(i),status,type,author);
                dtoList.add(reimbursementDTO);
            }

            ctx.json(dtoList);
            ctx.status(200);

        //Session validation
        }else{
            ctx.json("Session is invalid!!");
            ctx.redirect("/login", 401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/employee/home/",employeeHome);
        app.get("/employee/tickets", viewPastTickets);
        app.post("/employee/submit",submitRequest);
    }
}
