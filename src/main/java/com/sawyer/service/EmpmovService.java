package com.sawyer.service;

import com.sawyer.entity.Employeemov;

import java.sql.Date;
import java.util.List;

public interface EmpmovService {
    List<Employeemov> findAll();
    List<Employeemov> findbyemp(int emp_ID);
    void add(Employeemov mov);
    void delete(int mov_ID);
    List<Employeemov> findbytype(String movtype);
    List<Employeemov> findby(Integer emp_ID, Date datea, Date dateb, String movtype);
}
