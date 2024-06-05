package com.sawyer.entity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sawyer.entity.init.CustomSqlDateDeserializer;
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

    private int dim_ID;
    private int emp_ID;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date process_date;
    private String reason;
    private String emp_name; //emp
    private String gender; //emp
    private int dep_ID; //emp
    private String dep_name;
    private int pos_ID; //emp
    private  String pos_name;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date date; //emp
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date confirm_date; //emp
    private String process_state;
}
