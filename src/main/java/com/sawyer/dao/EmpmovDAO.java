package com.sawyer.dao;

import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Position;

import java.util.List;

public interface EmpmovDAO {
    List<Employeemov> findAll();
    void add(Employeemov mov);
    void delete(int mov_ID);
    List<Employeemov> findbyemp(int emp_ID);
}
