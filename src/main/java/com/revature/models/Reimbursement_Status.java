package com.revature.models;

import java.util.Objects;

public class Reimbursement_Status {

    private Integer status_ID;
    private String status;

    public Reimbursement_Status() {
    }

    public Reimbursement_Status(Integer status_ID, String status) {
        this.status_ID = status_ID;
        this.status = status;
    }

    public Integer getStatus_ID() {
        return status_ID;
    }

    public void setStatus_ID(Integer status_ID) {
        this.status_ID = status_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement_Status)) return false;
        Reimbursement_Status that = (Reimbursement_Status) o;
        return Objects.equals(getStatus_ID(), that.getStatus_ID()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus_ID(), getStatus());
    }

    @Override
    public String toString() {
        return "Reimbursement_Status{" +
                "status_ID=" + status_ID +
                ", status='" + status + '\'' +
                '}';
    }
}
