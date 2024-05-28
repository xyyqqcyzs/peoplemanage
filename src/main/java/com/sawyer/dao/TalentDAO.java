package com.sawyer.dao;

import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Talentpool;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface TalentDAO {
    List<Talentpool> findAll();
    void add(Talentpool Tal);
    void delete(int id);

    Talentpool findbyID(int id);
}
