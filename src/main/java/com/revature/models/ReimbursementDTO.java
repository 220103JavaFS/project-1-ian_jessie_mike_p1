package com.revature.models;

import java.util.Objects;

public class ReimbursementDTO {

    private Reimbursement request;
    private Reimbursement_Status status;
    private Reimbursement_Type type;

    public ReimbursementDTO() {
    }

    public ReimbursementDTO(Reimbursement request, Reimbursement_Status status, Reimbursement_Type type) {
        this.request = request;
        this.status = status;
        this.type = type;
    }

    public Reimbursement getRequest() {
        return request;
    }

    public void setRequest(Reimbursement request) {
        this.request = request;
    }

    public Reimbursement_Status getStatus() {
        return status;
    }

    public void setStatus(Reimbursement_Status status) {
        this.status = status;
    }

    public Reimbursement_Type getType() {
        return type;
    }

    public void setType(Reimbursement_Type type) {
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
