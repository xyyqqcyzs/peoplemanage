package com.sawyer.service;

import com.sawyer.entity.Dimission;

import java.util.Date;
import java.util.List;

public interface DimService {

    List<Dimission> findAll();

    void add(Dimission dim);
    void deleteEmployee(int emp_ID);

    void delete(int id);

    Dimission findbyID(int emp_ID);

    List<Dimission> findbypos(int pos_ID);

    List<Dimission> findbydep(int dep_ID);

    List<Dimission> findByDateRange(Date startDate, Date endDate);

}
