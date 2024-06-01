package com.sawyer.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Dimission {

    private int emp_ID;
    private String dim_date;
    private String dim_reason;

    private String emp_name; //emp
    private String gender; //emp
    private int dep_ID; //emp
    private String dep_name;
    private int pos_ID; //emp
    private  String pos_name;
    private Date date; //emp
    private Date confirm_date; //emp

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getDim_date() {
        return dim_date;
    }

    public void setDim_date(String dim_date) {
        this.dim_date = dim_date;
    }

    public String getDim_reason() {
        return dim_reason;
    }

    public void setDim_reason(String dim_reason) {
        this.dim_reason = dim_reason;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDep_ID() {
        return dep_ID;
    }

    public void setDep_ID(int dep_ID) {
        this.dep_ID = dep_ID;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public int getPos_ID() {
        return pos_ID;
    }

    public void setPos_ID(int pos_ID) {
        this.pos_ID = pos_ID;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(Date confirm_date) {
        this.confirm_date = confirm_date;
    }


}
