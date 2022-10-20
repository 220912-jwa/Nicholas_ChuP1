package com.revature.service;

import com.revature.daos.EmployeeDao;
import com.revature.entities.Employee;
import com.revature.entities.Reimbursement;

import java.util.List;

public class EmployeeAuth {

    public EmployeeDao employeeDao;

    public EmployeeAuth(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee login(String username, String pass) {
        Employee e = employeeDao.getEmployeeByUsername(username);
        System.out.println(e);

        if(e.getPass().equals(pass)) {
            System.out.println("Login is successful");
            return e;
        } else {
            System.out.println("Login unsuccessful");
            return null;
        }
    }

    public  void updateEf(int funds, int user_id) {
        System.out.println(funds);
        employeeDao.updateFunds(funds,user_id);
    }
}
