package com.sawyer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Field;
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
    private String confirm_process;
    private Integer annual_holiday;

    private  Integer lieu_holiday;

    public Integer getPropertyValue(Object obj, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(propertyName);
        field.setAccessible(true);
        return (Integer) field.get(obj);
    }

    public void get_after_dep_ID(int mov_dep_ID) {
        this.dep_ID = mov_dep_ID;
    }
    public void get_after_pos_ID(int mov_pos_ID) {
        this.pos_ID = mov_pos_ID;
    }
}
