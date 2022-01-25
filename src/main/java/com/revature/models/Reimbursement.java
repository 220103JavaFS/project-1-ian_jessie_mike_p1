package com.revature.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class Reimbursement {

    private Integer reimbursement_ID;
    private Float reimbursement_Amount;
    private Timestamp time_Submitted;
    private Timestamp time_Resolved;
    private String description;
    private byte[] reciept;
    private Integer author_ID;
    private Integer resolver_ID;
    private Integer status_ID;
    private Integer type_ID;

    public Integer getReimbursement_ID() {
        return reimbursement_ID;
    }

    public void setReimbursement_ID(Integer reimbursement_ID) {
        this.reimbursement_ID = reimbursement_ID;
    }

    public Float getReimbursement_Amount() {
        return reimbursement_Amount;
    }

    public void setReimbursement_Amount(Float reimbursement_Amount) {this.reimbursement_Amount = reimbursement_Amount;}

    public Timestamp getTime_Submitted() {
        return time_Submitted;
    }

    public void setTime_Submitted(Timestamp time_Submitted) {
        this.time_Submitted = time_Submitted;
    }

    public Timestamp getTime_Resolved() {
        return time_Resolved;
    }

    public void setTime_Resolved(Timestamp time_Resolved) {
        this.time_Resolved = time_Resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReciept() {
        return reciept;
    }

    public void setReciept(byte[] reciept) {
        this.reciept = reciept;
    }

    public Integer getAuthor_ID() {
        return author_ID;
    }

    public void setAuthor_ID(Integer author_ID) {
        this.author_ID = author_ID;
    }

    public Integer getResolver_ID() {
        return resolver_ID;
    }

    public void setResolver_ID(Integer resolver_ID) {
        this.resolver_ID = resolver_ID;
    }

    public Integer getStatus_ID() {
        return status_ID;
    }

    public void setStatus_ID(Integer status_ID) {
        this.status_ID = status_ID;
    }

    public Integer getType_ID() {
        return type_ID;
    }

    public void setType_ID(Integer type_ID) {
        this.type_ID = type_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return getReciept() == that.getReciept() && Objects.equals(getReimbursement_ID(), that.getReimbursement_ID()) && Objects.equals(getReimbursement_Amount(), that.getReimbursement_Amount()) && Objects.equals(getTime_Submitted(), that.getTime_Submitted()) && Objects.equals(getTime_Resolved(), that.getTime_Resolved()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAuthor_ID(), that.getAuthor_ID()) && Objects.equals(getResolver_ID(), that.getResolver_ID()) && Objects.equals(getStatus_ID(), that.getStatus_ID()) && Objects.equals(getType_ID(), that.getType_ID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReimbursement_ID(), getReimbursement_Amount(), getTime_Submitted(), getTime_Resolved(), getDescription(), getReciept(), getAuthor_ID(), getResolver_ID(), getStatus_ID(), getType_ID());
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursement_ID=" + reimbursement_ID +
                ", reimbursement_Amount=" + reimbursement_Amount +
                ", time_Submitted=" + time_Submitted +
                ", time_Resolved=" + time_Resolved +
                ", description='" + description + '\'' +
                ", reciept=" + reciept +
                ", author_ID=" + author_ID +
                ", resolver_ID=" + resolver_ID +
                ", status_ID=" + status_ID +
                ", type_ID=" + type_ID +
                '}';
    }
}
