package com.sawyer.dao;

import com.sawyer.entity.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Component
public interface DepartmentDAO {
    List<Department> findAll();

    void add(Department dep);

    void delete(int id);

    Department find(int id);

    void update(Department dep);
}
