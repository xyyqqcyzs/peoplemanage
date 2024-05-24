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
public class Employeemov {
    private int mov_ID;
    private int emp_ID;
    private String emp_name;
    private int before_dep;
    private String before_dep_name;
    private int after_dep;
    private String after_dep_name;
    private int before_pos;
    private String before_pos_name;
    private int after_pos;
    private String after_pos_name;
    private Date mov_date;
    private String reason;
    private String movtype;

    public int getAfter_dep() {
        return after_dep;
    }

    public int getAfter_pos() {
        return after_pos;
    }

    public int getEmp_ID() {
        return emp_ID;
    }

}
