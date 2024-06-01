package com.sawyer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

import com.sawyer.entity.init.CustomSqlDateDeserializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer emp_ID;
    private String emp_name;
    //private Byte[] photo;
    private String gender;
    private Integer dep_ID;
    private String dep_name;
    private Integer pos_ID;
    private  String pos_name;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date date;
    private String entermode;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date birthday;
    private String phone;
    private String email;
    private String address;
    private String work_experience;
    private String academic_background;
    private String emp_type;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date confirm_date;
    private String intern_situation;
    private String intern_detail;
    public void get_after_dep_ID(int mov_dep_ID) {
        this.dep_ID = mov_dep_ID;
    }
    public void get_after_pos_ID(int mov_pos_ID) {
        this.pos_ID = mov_pos_ID;
    }

    public Integer getEmp_ID() {
        return emp_ID;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public Date getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(Date confirm_date) {
        this.confirm_date = confirm_date;
    }

    public String getIntern_situation() {
        return intern_situation;
    }

    public void setIntern_situation(String intern_situation) {
        this.intern_situation = intern_situation;
    }

    public String getIntern_detail() {
        return intern_detail;
    }

    public void setIntern_detail(String intern_detail) {
        this.intern_detail = intern_detail;
    }

    public void setEmp_ID(Integer emp_ID) {
        this.emp_ID = emp_ID;
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

    public Integer getDep_ID() {
        return dep_ID;
    }

    public void setDep_ID(Integer dep_ID) {
        this.dep_ID = dep_ID;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Integer getPos_ID() {
        return pos_ID;
    }

    public void setPos_ID(Integer pos_ID) {
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

    public String getEntermode() {
        return entermode;
    }

    public void setEntermode(String entermode) {
        this.entermode = entermode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getAcademic_background() {
        return academic_background;
    }

    public void setAcademic_background(String academic_background) {
        this.academic_background = academic_background;
    }
}
