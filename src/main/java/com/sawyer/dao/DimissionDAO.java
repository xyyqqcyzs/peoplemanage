package com.sawyer.dao;
import org.apache.ibatis.annotations.Param;
import com.sawyer.entity.Department;
import com.sawyer.entity.Dimission;
import com.sawyer.entity.Employee;
import java.util.Date;

import java.util.List;

public interface DimissionDAO {

    List<Dimission> findAll();

    public Employee selectEmployeeById(int emp_ID);
    void addDimission ( Dimission dim);
    void deleteEmployeeById(int emp_ID);
    void add(Dimission dim);

    void deleteEmployee(int emp_ID);

    void delete(int id);

    Dimission findbyID(int emp_ID);

    List<Dimission> findbypos(int pos_ID);

    List<Dimission> findbydep(int dep_ID);

    List<Dimission> findByDateRange(Date startDate, Date endDate);


}
