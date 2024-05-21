package com.sawyer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private int emp_ID;
    private String emp_name;
    private String gender;
    private int dep_ID;
    private String dep_name;
    private int pos_ID;
    private  String pos_name;
    private Date date;
    private String entermode;
    private Date birthday;
    private String phone;
    private String email;
    private String address;
    private String work_experience;
    private String academic_background;
    private String emp_type;
    private Date confirm_date;
    private String intern_situation;
    private String intern_detail;
}
