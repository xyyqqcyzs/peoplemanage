package com.sawyer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sawyer.entity.init.CustomSqlDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movtime {

    private  Integer emp_ID;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date datea;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date dateb;
    private String movtype;
    private String process_state;
}
