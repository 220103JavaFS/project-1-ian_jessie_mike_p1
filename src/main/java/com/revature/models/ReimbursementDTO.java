package com.revature.models;

import java.util.Objects;

public class ReimbursementDTO {

    private Reimbursement request;
    private String status;
    private String type;
    private Users user;

    public ReimbursementDTO() {
    }

    public ReimbursementDTO(Reimbursement request, String status, String type, Users user) {
        this.request = request;
        this.status = status;
        this.type = type;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Reimbursement getRequest() {
        return request;
    }

    public void setRequest(Reimbursement request) {
        this.request = request;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReimbursementDTO)) return false;
        ReimbursementDTO that = (ReimbursementDTO) o;
        return Objects.equals(getRequest(), that.getRequest()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequest(), getStatus(), getType());
    }

    @Override
    public String toString() {
        return "ReimbursementDTO{" +
                "request=" + request +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
