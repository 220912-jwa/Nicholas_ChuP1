package com.revature.service;

import com.revature.daos.EmployeeDao;
import com.revature.daos.ReimbursementDao;
import com.revature.entities.Reimbursement;
import  com.revature.entities.Employee;

import java.util.List;

public class ReimbursementService {

    public ReimbursementDao reimbursementDao;
    private Employee employee;
    private EmployeeDao employeeDao;

    public ReimbursementService(ReimbursementDao reimbursementDao, EmployeeDao employeeDao) {
        this.reimbursementDao = reimbursementDao;
        this.employeeDao = employeeDao;
    }

    public Reimbursement createRe(Reimbursement newRe) {
//        if(newRe.getEvent_cost() > newRe.getFunds()) {
//            return null;
//        }
        return reimbursementDao.create(newRe);
    }

    public List<Reimbursement> getAllRe(int orderId) {
        System.out.println(orderId);

        employee = employeeDao.getById(orderId);
        System.out.println(employee);
        if(employee.isFinance_manager()){
            return reimbursementDao.getAll();
        }else{
            return reimbursementDao.getReimbursement(orderId);
        }

    }
    public Reimbursement getById(int reId) {
        return reimbursementDao.getById(reId);
    }

    public  void updateRe(String status, int re_id) {
        reimbursementDao.updateApproved(status,re_id);
        reimbursementDao.updateDeny(status,re_id);
    }



}
