package com.sawyer.dao;

import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface EmpDAO {
    List<Employee> findAll();

    List<Employee> findbypos(int pos_ID);

    List<Employee> findbydep(int dep_ID);

    void add(Employee emp);

    void delete(int id);

    Employee findbyID(int id);

    void update(Employee emp);

    List<Employee> findbyMode(String mode);

    List<Employee> findbyemptype(String empType);

    Career findcareer(int id);

    List<Employee> findbyall(@Param("dep_ID") Integer dep_ID, @Param("pos_ID") Integer pos_ID,
                                    @Param("datea") Date datea, @Param("dateb") Date dateb, @Param("entermode") String entermode, @Param("emp_type") String emp_type,
                                    @Param("confirm_datea") Date confirm_datea, @Param("confirm_dateb") Date confirm_dateb,@Param("intern_situation") String intern_situation);
}
