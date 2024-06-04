package com.sawyer.service;

import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Holiday;

import java.sql.Date;
import java.util.List;

public interface HolidayService {
    List<Holiday> findAll();
    List<Holiday> findbyemp(int emp_ID);
    void add(Holiday hol);
    void delete(int hol_ID);
    List<Holiday> findbyprocess(String process_state);
    Holiday findbyID(int id);
    void update(Holiday hol);


}
