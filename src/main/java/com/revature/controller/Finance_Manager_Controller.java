package com.revature.controller;

import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Finance_Manager_Controller extends Controller{

    private final UserService userService = new UserService();
    private final ReimbursementService reimbursementService = new ReimbursementService();

    Handler viewAllReimbursementRequests = (ctx) -> {};

    Handler filterRequestsByStatus = (ctx) -> {};

    Handler approveDenyRequest = (ctx) -> {};

    @Override
    public void addRoutes(Javalin app) {

    }
}
