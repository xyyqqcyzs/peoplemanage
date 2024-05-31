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
public class Talentpool {
    private Integer talent_ID;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private Date birthday;
    private String academic;
    private String work_experience;

}
