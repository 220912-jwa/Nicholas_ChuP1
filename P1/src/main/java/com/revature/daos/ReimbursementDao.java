package com.revature.daos;

import com.revature.entities.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDao implements ERS<Reimbursement>{
    @Override
    public Reimbursement getById(int id) {
        String sql = "select * from ERS.reimbursement where re_id = ?";

        try (Connection conn = ConnectionUtil.createConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Reimbursement(
                        rs.getInt("re_id"),
                        rs.getString("event_date"),
                        rs.getString("event_time"),
                        rs.getString("event_location"),
                        rs.getString("description"),
                        rs.getInt("event_cost"),
                        rs.getString("event_type"),
                        rs.getString("event_justification"),
                        rs.getString("status"),
                        rs.getInt("order_id"),
                rs.getString("passed"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        List<Reimbursement> Re = new ArrayList<>();
        String sql = "select * from ERS.reimbursement where status = 'PENDING'";
        try(Connection conn = ConnectionUtil.createConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Re.add(new Reimbursement(
                        rs.getInt("re_id"),
                        rs.getString("event_date"),
                        rs.getString("event_time"),
                        rs.getString("event_location"),
                        rs.getString("description"),
                        rs.getInt("event_cost"),
                        rs.getString("event_type"),
                        rs.getString("event_justification"),
                        rs.getString("status"),
                        rs.getInt("order_id"),
                rs.getString("passed")));

            }
            return Re;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Reimbursement> getReimbursement(int order_id) {
        List<Reimbursement> Re = new ArrayList<>();
        String sql = "select * from ERS.reimbursement where order_id = ?";

        try(Connection conn = ConnectionUtil.createConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Re.add(new Reimbursement(
                        rs.getInt("re_id"),
                        rs.getString("event_date"),
                        rs.getString("event_time"),
                        rs.getString("event_location"),
                        rs.getString("description"),
                        rs.getInt("event_cost"),
                        rs.getString("event_type"),
                        rs.getString("event_justification"),
                        rs.getString("status"),
                        rs.getInt("order_id"),
                        rs.getString("passed")));
            }
            return Re;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reimbursement create(Reimbursement reimbursement) {
        String sql = "insert into ERS.reimbursement values (default, Cast(? AS DATE), CAST(? AS TIME), ?, ?, ?, ?, ?, ? ,?, ?) returning *";

        try(Connection conn = ConnectionUtil.createConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,reimbursement.getEvent_date());
            ps.setString(2, reimbursement.getEvent_time());
            ps.setString(3,reimbursement.getEvent_location());
            ps.setString(4,reimbursement.getDescription());
            ps.setInt(5, reimbursement.getEvent_cost());
            ps.setString(6, reimbursement.getEvent_type());
            ps.setString(7, reimbursement.getEvent_justification());
            ps.setString(8, reimbursement.getStatus());
            ps.setInt(9,reimbursement.getOrder_id());
            ps.setString(10, reimbursement.isPassed());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Reimbursement(
                        rs.getInt("re_id"),
                        rs.getString("event_date"),
                        rs.getString("event_time"),
                        rs.getString("event_location"),
                        rs.getString("description"),
                        rs.getInt("event_cost"),
                        rs.getString("event_type"),
                        rs.getString("event_justification"),
                        rs.getString("status"),
                        rs.getInt("order_id"),
                        rs.getString("passed"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
    updated status and passed
    status, passed, re_id

     */

    public void updateApproved(String status, int re_id){
        String sql = "update ERS.reimbursement set status = ?,passed = 'PASSED'"
                + "where re_id = ?";

        try (Connection conn = ConnectionUtil.createConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2,re_id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeny(String status, int re_id){
        String sql = "update ERS.reimbursement set status = ?,passed = 'FAILED'"
                + "where re_id = ?";

        try (Connection conn = ConnectionUtil.createConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2,re_id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reimbursement tUpdated) {
        String sql = "update ERS.reimbursement set status = ?,passed = ?"
                + "where re_id = ?";

        try (Connection conn = ConnectionUtil.createConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tUpdated.getStatus());
            ps.setString(2,tUpdated.getPass());
            ps.setInt(3,tUpdated.getRe_id());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//    public void update(Reimbursement tUpdated) {
//        String sql = "update ERS.reimbursement set event_date = ?, event_time = ?, event_location = ?, " +
//                "description = ?, event_cost = ?, event_type = ?, event_justification = ?, status = ?, passed = ? " +
//                "where id = ?";
//
//        try (Connection conn = ConnectionUtil.createConnection()) {
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, tUpdated.getEvent_date());
//            ps.setString(2, tUpdated.getEvent_time());
//            ps.setString(3, tUpdated.getEvent_location());
//            ps.setString(4, tUpdated.getDescription());
//            ps.setInt(5, tUpdated.getEvent_cost());
//            ps.setString(6, tUpdated.getEvent_type());
//            ps.setString(7, tUpdated.getEvent_justification());
//            ps.setString(8, tUpdated.getStatus());
//            ps.setString(9,tUpdated.getPass());
//
//            ps.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}
