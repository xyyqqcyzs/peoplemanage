package com.sawyer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Blob;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer emp_ID;
    private String emp_name;
    private String photo;
    private String gender;
    private Integer dep_ID;
    private String dep_name;
    private Integer pos_ID;
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

    public void get_mov_Emp_ID(int mov_Emp_ID) {
        this.emp_ID = mov_Emp_ID;
    }
    public void get_after_dep_ID(int mov_dep_ID) {
        this.dep_ID = mov_dep_ID;
    }
    public void get_after_pos_ID(int mov_pos_ID) {
        this.pos_ID = mov_pos_ID;
    }
}
