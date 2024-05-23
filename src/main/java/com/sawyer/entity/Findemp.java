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
public class Findemp {
    private Integer dep_ID;
    private Integer pos_ID;
    private Date datea;//入职日期在此之后
    private Date dateb;//入职日期在此之前
    private String entermode;//入职方式
    private String emp_type;//员工类型：实习生，正式员工
    private Date confirm_datea;//转正日期
    private Date confirm_dateb;//转正日期
    private String intern_situation;//已转正，延期，未通过

}
