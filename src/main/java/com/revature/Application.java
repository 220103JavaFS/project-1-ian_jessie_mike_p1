package com.revature;
import com.revature.controller.*;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Application{


    //Import logger
    private static Logger mylog = LoggerFactory.getLogger(Application.class);
    private static Javalin app;


    public static void main(String[] args) {

        mylog.info("Application starting");

        //Create Http server
        //Create Http server
        app = Javalin.create();
        configure(new Login_Controller(), new Registration_Controller(), new Employee_Controller(), new Finance_Manager_Controller());
        app.start(6000);
    }

//
    private static void configure(Controller... controllers) {
        for (Controller c : controllers) {
            c.addRoutes(app);
        }
    }
}