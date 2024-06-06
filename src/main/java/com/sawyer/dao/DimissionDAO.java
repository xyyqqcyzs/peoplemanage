package com.sawyer.dao;

import com.sawyer.entity.Department;
import com.sawyer.entity.Dimission;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Employeemov;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

import java.util.List;

public interface DimissionDAO {

    List<Dimission> findAll();
    void add(Dimission dim);
    void delete(int id);
    Dimission findbyID(int emp_ID);
    void update(Dimission dim);
    List<Dimission> findbypos(int pos_ID);
    List<Dimission> findbydep(int dep_ID);
    List<Dimission> findByDateRange(Date startDate, Date endDate);
    Dimission findbyemp(int emp_ID);

    List<Dimission> findbyprocess(String process_state);
}
