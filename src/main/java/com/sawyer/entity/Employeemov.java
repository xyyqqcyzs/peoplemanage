package com.sawyer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sawyer.entity.init.CustomSqlDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employeemov {
    private Integer mov_ID;
    private Integer emp_ID;
    private String emp_name;
    private Integer before_dep;
    private String before_depname;
    private Integer after_dep;
    private String after_depname;
    private Integer before_pos;
    private String before_posname;
    private Integer after_pos;
    private String after_posname;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date mov_date;
    private String reason;
    private String movtype;
    private String process_state;

    public int getAfter_dep() {
        return after_dep;
    }

    public int getAfter_pos() {
        return after_pos;
    }

    public int getEmp_ID() {
        return emp_ID;
    }

}
