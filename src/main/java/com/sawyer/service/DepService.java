package com.sawyer.service;

import com.sawyer.entity.Department;

import com.sawyer.entity.Emp;

import java.util.List;
public interface DepService {
    List<Department> findAll();

    void add(Department dep);

    void delete(int id);

    Department find(int id);

    void update(Department dep);
}
