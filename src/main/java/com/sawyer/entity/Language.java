package com.sawyer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Language {
    private int language_ID;
    private int emp_ID;
    private String emp_name;
    private String language_name;
    private String proficiency_level;
}
