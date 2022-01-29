package com.revature.controller;

import com.revature.service.Employee_Service;
import com.revature.service.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Employee_Controller extends Controller{

    private final UserService userService = new UserService();
    Employee_Service employeeService = new Employee_Service();

    Handler viewPastTickets = (ctx) -> {};

    Handler ReimbursementRequest = (ctx) -> {};

    @Override
    public void addRoutes(Javalin app) {
//        app.before(ctx -> {
//            if(ctx.req.getSession(false)!=null && ctx.req.getSession().getAttribute("user_role").equals(1)){
//                continue;
//            }else{
//                ctx.json("Credentials invalid!!");
//                ctx.redirect("/login", 401);
//            }
//        });
    }
}
