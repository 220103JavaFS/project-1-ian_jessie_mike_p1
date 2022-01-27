package com.revature.controller;

import com.revature.service.Finance_Manager_Service;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Finance_Manager_Controller extends Controller{

    private Finance_Manager_Service fmService = new Finance_Manager_Service();

    Handler viewAllReimbursementRequests = (ctx) -> {};

    Handler filterRequestsByStatus = (ctx) -> {};

    Handler approveDenyRequest = (ctx) -> {};

    @Override
    public void addRoutes(Javalin app) {

    }
}
