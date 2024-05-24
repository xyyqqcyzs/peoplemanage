package com.sawyer.dao;

import com.sawyer.entity.Employee;

import java.util.List;

public interface EmpDAO {
    List<Employee> findAll();

    List<Employee> findbypos(int pos_ID);

    List<Employee> findbydep(int dep_ID);

    void add(Employee emp);

    void delete(int id);

    Employee findbyID(int id);

    void update(Employee emp);
}
