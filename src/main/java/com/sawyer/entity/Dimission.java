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
    private Date dim_date;
    private String dim_reason;
    private String emp_name; //emp
    private String gender; //emp
    private int dep_ID; //emp
    private String dep_name;
    private int pos_ID; //emp
    private  String pos_name;
    private Date date; //emp
    private Date confirm_date; //emp

}
