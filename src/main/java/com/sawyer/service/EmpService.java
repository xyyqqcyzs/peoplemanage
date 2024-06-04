package com.sawyer.service;

import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;

import java.sql.Date;
import java.util.List;

public interface EmpService {
    List<Employee> findAll();

    List<Employee> findbypos(int pos_ID);

    List<Employee> findbydep(int dep_ID);

    void add(Employee emp);

    void delete(int id);

    Employee findbyID(int id);

    void update(Employee emp);

    List<Employee> findbyMode(String mode);

    List<Employee> findbyemptype(String emp_type);

    Career findcareer(int id);

    List<Employee> findbyall(Integer dep_ID, Integer pos_ID, Date datea, Date dateb,String entermode, String emp_type, Date confirm_datea, Date confirm_dateb,String intern_situation);

    List<Employee> findbyprocess(String confirm_process);
}
