package com.sawyer.service;

import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Talentpool;

import java.sql.Date;
import java.util.List;

public interface TalentService {
    List<Talentpool> findAll();
    void add(Talentpool tal);
    void delete(int id);

    Talentpool findbyID(int id);
}
