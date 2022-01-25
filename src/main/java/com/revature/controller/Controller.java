package com.revature.controller;
import io.javalin.Javalin;

public abstract class Controller {

        public abstract void addRoutes(Javalin app);

}
