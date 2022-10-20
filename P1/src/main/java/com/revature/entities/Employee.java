package com.revature.entities;

public class Employee {
    public int user_id;
    public String first_name;
    public String last_name;
    public String username;
    public String pass;
    public int funds;
    public boolean finance_manager;


    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String username, String pass, int funds, boolean finance_manager) {
        this.user_id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.username = username;
        this.pass = pass;
        this.funds = funds;
        this.finance_manager = finance_manager;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public boolean isFinance_manager() {
        return finance_manager;
    }

    public void setFinance_manager(boolean finance_manager) {
        this.finance_manager = finance_manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + user_id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", funds=" + funds +
                ", finance_manager=" + finance_manager +
                '}';
    }
}
