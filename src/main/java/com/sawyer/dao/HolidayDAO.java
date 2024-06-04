package com.sawyer.dao;

import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Holiday;

import java.util.List;

public interface HolidayDAO {
    List<Holiday> findAll();
    void add(Holiday hol);
    void delete(Integer id);
    List<Holiday> findbyemp(Integer emp_ID);
    List<Holiday> findbyprocess(String process);
    Holiday findbyID(int id);
    void update(Holiday hol);

}
