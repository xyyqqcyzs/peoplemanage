package com.sawyer.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position {
    private Integer pos_ID;
    private String pos_name;
    private String creat_date;
    private String dep_ID;
    private String dep_name;
    private String detail;

}
