package com.revature.controller;

import com.revature.entities.Employee;
import com.revature.entities.Reimbursement;
import com.revature.service.EmployeeAuth;
import com.revature.service.ReimbursementService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import java.io.IOException;
import java.util.List;

public class ReimbursementController {

    public ReimbursementService reimbursementService;


    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService = reimbursementService;
    }

    public void createReim(Context ctx) throws IOException {
        Reimbursement re = ctx.bodyAsClass(Reimbursement.class);
        Reimbursement newRe = reimbursementService.createRe(re);

        if(newRe != null) {
            ctx.status(HttpCode.CREATED);
            ctx.json(newRe);
        } else {
            ctx.res.sendError(400);
        }
    }

    public void getOrderById(Context ctx) {
        int reId = Integer.parseInt(ctx.pathParam("reid"));
        ctx.status(200);
        ctx.json(reimbursementService.getById(reId));
    }

    public void getAllReim(Context ctx) {
        int orderId = Integer.parseInt(ctx.pathParam("id"));
        ctx.status(200);
        ctx.json(reimbursementService.getAllRe(orderId));
    }

    public void updateReim(Context ctx) {
        String status = ctx.pathParam("status");
        int re_id = Integer.parseInt(ctx.pathParam("re_id"));
        ctx.status(200);
        reimbursementService.updateRe(status,re_id);


    }


}
