package com.sawyer.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sawyer.entity.init.CustomSqlDateDeserializer;
import com.sawyer.entity.init.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Holiday {
    private Integer id;
    private Integer emp_ID;
    private String emp_name;
    private Integer annual_holiday;//年假剩余天数
    private Integer lieu_holiday;//调休假剩余天数
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime start_date;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime end_date;
    private String type;//年假/调休假
    private String process_state;//处理状态
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    private Date process_date;


}
