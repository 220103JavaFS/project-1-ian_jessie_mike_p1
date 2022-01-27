package com.revature.controller;

import com.revature.service.Employee_Service;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Employee_Controller extends Controller{

    Employee_Service employeeService = new Employee_Service();

    Handler viewPastTickets = (ctx) -> {};

    Handler ReimbursementRequest = (ctx) -> {};

    @Override
    public void addRoutes(Javalin app) {

    }
}
