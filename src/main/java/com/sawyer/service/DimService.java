package com.sawyer.service;

import com.sawyer.entity.Dimission;

import java.util.Date;
import java.util.List;

public interface DimService {

    List<Dimission> findAll();

    void add(Dimission dim);

    void delete(int id);

    void update(Dimission dim);

    Dimission findbyID(int dim_ID);

    List<Dimission> findbypos(int pos_ID);

    List<Dimission> findbydep(int dep_ID);
    List<Dimission> findByDateRange(Date startDate, Date endDate);

    Dimission findbyemp(int emp_Id);

    List<Dimission> findbyprocess(String process_state);

    void insert(Dimission dim);

    List<Dimission> finddimissed();
}