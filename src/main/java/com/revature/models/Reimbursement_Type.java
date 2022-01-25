package com.revature.models;

import java.util.Objects;

public class Reimbursement_Type {

    private Integer type_ID;
    private String reimbursement_Type;

    public Integer getType_ID() {
        return type_ID;
    }

    public void setType_ID(Integer type_ID) {
        this.type_ID = type_ID;
    }

    public String getReimbursement_Type() {
        return reimbursement_Type;
    }

    public void setReimbursement_Type(String reimbursement_Type) {
        this.reimbursement_Type = reimbursement_Type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement_Type)) return false;
        Reimbursement_Type that = (Reimbursement_Type) o;
        return Objects.equals(getType_ID(), that.getType_ID()) && Objects.equals(getReimbursement_Type(), that.getReimbursement_Type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType_ID(), getReimbursement_Type());
    }

    @Override
    public String toString() {
        return "Reimbursement_Type{" +
                "type_ID=" + type_ID +
                ", reimbursement_Type='" + reimbursement_Type + '\'' +
                '}';
    }
}
