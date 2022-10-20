package com.revature.entities;

import java.sql.Date;

public class Reimbursement extends Employee{
   public int re_id;
    public String event_date;
    public String event_time;
    public String event_location;
    public String description;
    public int event_cost;
    public String passed;
    public String event_type;
    public String event_justification;
    public String status;
    public int order_id;

    public Reimbursement() {
    }

    public Reimbursement(int re_id, String event_date, String event_time, String event_location, String description, int event_cost, String event_type, String event_justification, String status, int order_id,  String passed) {
        this.re_id = re_id;
        this.event_date = event_date;
        this.event_time = event_time;
        this.event_location = event_location;
        this.description = description;
        this.event_cost = event_cost;
        this.event_type = event_type;
        this.event_justification = event_justification;
        this.status = status;
        this.order_id = order_id;
        this.passed = passed;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEvent_cost() {
        return event_cost;
    }

    public void setEvent_cost(int event_cost) {
        this.event_cost = event_cost;
    }

    public String isPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_justification() {
        return event_justification;
    }

    public void setEvent_justification(String event_justification) {
        this.event_justification = event_justification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "re_id=" + re_id +
                ", event_date='" + event_date + '\'' +
                ", event_time='" + event_time + '\'' +
                ", event_location='" + event_location + '\'' +
                ", description='" + description + '\'' +
                ", event_cost=" + event_cost +
                ", passed=" + passed +
                ", event_type='" + event_type + '\'' +
                ", event_justification='" + event_justification + '\'' +
                ", status='" + status + '\'' +
                ", order_id=" + order_id +
                '}';
    }
}
