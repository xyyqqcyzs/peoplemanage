package com.sawyer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Family {
    private int relation_ID;
    private int emp_ID;
    private String emp_name;
    private String relation_name;
    private String relation_type;
    private String contact_info;
}
