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
public class Process {
    int id;
    @JsonDeserialize(using = CustomSqlDateDeserializer.class)
    Date date;
}
