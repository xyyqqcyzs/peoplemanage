package com.sawyer.service;

import com.sawyer.entity.Employeemov;

import java.util.List;

public interface EmpmovService {
    List<Employeemov> findAll();
    List<Employeemov> findbyemp(int emp_ID);
    void add(Employeemov mov);
    void delete(int mov_ID);

}
