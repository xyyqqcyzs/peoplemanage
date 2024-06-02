package com.sawyer.dao;

import com.sawyer.entity.Employee;

import java.util.Date;
import java.util.List;

public interface ReportDAO {

    List<Employee> findAll();

    List<Employee> findbydep(int dep_ID);

    List<Employee> findbypos(int pos_ID);

    List<Employee> findByDate(Date startDate, Date endDate);

    List<Employee> findByConDate(Date startDate, Date endDate);

}
