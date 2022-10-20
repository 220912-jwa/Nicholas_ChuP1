package com.revature.daos;

import com.revature.entities.Employee;
import com.revature.util.ConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements ERS<Employee>{



    @Override
    public Employee getById(int id) {
        String sql = "select * from ERS.employee where user_id = ?";

        try (Connection conn = ConnectionUtil.createConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getInt("funds"),
                        rs.getBoolean("finance_manager"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from ERS.employee";
        try(Connection conn = ConnectionUtil.createConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                 employees.add(new Employee(
                         rs.getInt("user_id"),
                         rs.getString("first_name"),
                         rs.getString("last_name"),
                         rs.getString("username"),
                         rs.getString("pass"),
                         rs.getInt("funds"),
                         rs.getBoolean("finance_manager")));

            }
            return employees;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Employee create(Employee employee) {
        String sql = "insert into ERS.employee values (default, ?, ?, ?, ?, ?, ?) returning *";

        try(Connection conn = ConnectionUtil.createConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUsername());
            ps.setString(4, employee.getPass());
            ps.setInt(5, 1000);
            ps.setBoolean(6, false);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
               return new Employee(
                       rs.getInt("user_id"),
                       rs.getString("first_name"),
                       rs.getString("last_name"),
                       rs.getString("username"),
                       rs.getString("pass"),
                       rs.getInt("funds"),
                       rs.getBoolean("finance_manager"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Employee getEmployeeByUsername(String username){
        try (Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from ERS.employee where username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Employee(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getInt("funds"),
                        rs.getBoolean("finance_manager")
                );

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateFunds(int funds, int user_id) {
        String sql = "update ERS.employee set funds = ?"
                + "where user_id = ?";

        try (Connection connection = ConnectionUtil.createConnection()) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, funds);
            ps.setInt(2, user_id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void update(Employee aUpdated) {
        String sql = "update ERS.employee set funds = ?"
                + "where user_id = ?";

        try (Connection connection = ConnectionUtil.createConnection()) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, aUpdated.getFunds());
            ps.setInt(2,aUpdated.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
