package com.revature;

import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;
import com.revature.daos.EmployeeDao;
import com.revature.daos.ReimbursementDao;
import com.revature.service.EmployeeAuth;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {
    public static void main(String[] args) {
        EmployeeController ec = new EmployeeController(new EmployeeAuth(new EmployeeDao()));
        ReimbursementController reimbursementController = new ReimbursementController(new ReimbursementService( new ReimbursementDao(),new EmployeeDao()));
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(8080);

        app.post("/authenticate", ec.login);
        app.post("/create", reimbursementController::createReim);
        app.get("/create/{id}", reimbursementController::getAllReim);
        app.get("/obtain/{reid}", reimbursementController::getOrderById);
        app.post("/funds/{funds}/{userId}",ec::updateFunds);
        app.put("/create/{status}/{re_id}", reimbursementController::updateReim);
        app.get("/getSession", ctx -> {
            if (ctx.sessionAttribute("loggedInUser") != null) {
                ctx.json(ctx.sessionAttribute("loggedInUser"));
            } else {
                ctx.json("No one is logged in");
            }

        });



    }
}
