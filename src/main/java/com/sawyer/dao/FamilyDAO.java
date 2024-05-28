package com.sawyer.dao;

import com.sawyer.entity.Family;
import com.sawyer.entity.Language;

import java.util.List;

public interface FamilyDAO {
    List<Family> findbyemp(int emp_ID);
    void add(Family fan);
    void delete(int relation_ID);
    void update(Family fan);
}
