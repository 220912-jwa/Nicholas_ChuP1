package com.revature.controller;

import com.revature.entities.Employee;
import com.revature.entities.Reimbursement;
import com.revature.service.EmployeeAuth;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpCode;

public class EmployeeController {

    public EmployeeAuth employeeAuth;


    public EmployeeController(EmployeeAuth employeeAuth) {
        this.employeeAuth = employeeAuth;

    }

    public Handler login = ctx -> {
         Employee e = ctx.bodyAsClass(Employee.class);
         Employee aue = employeeAuth.login(e.getUsername(),e.getPass());
         ctx.sessionAttribute("loggedInUser", aue);
        System.out.println(aue);
        if (aue != null) {
            ctx.status(200);
            ctx.json(aue);
        } else {
            ctx.status(400);
        }
    };


    public void updateFunds(Context ctx) {
        int funds = Integer.parseInt(ctx.pathParam("funds"));
        int user_id = Integer.parseInt(ctx.pathParam("userId"));
        ctx.status( 200);
        System.out.println(funds);
        employeeAuth.updateEf(funds,user_id);

    }


}
