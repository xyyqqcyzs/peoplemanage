package com.sawyer.service;

import com.sawyer.entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> findAll();

    List<Employee> findbypos(int pos_ID);

    List<Employee> findbydep(int dep_ID);

    void add(Employee emp);

    void delete(int id);

    Employee findbyID(int id);

    void update(Employee emp);
}
