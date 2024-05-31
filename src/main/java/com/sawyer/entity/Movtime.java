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
public class Movtime {

    private  Integer emp_ID;
    private Date datea;
    private Date dateb;
    private String movtype;

    private String process_state;
}
