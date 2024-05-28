package com.sawyer.service;

import com.sawyer.dao.FamilyDAO;
import com.sawyer.dao.LanguageDAO;
import com.sawyer.entity.Family;
import com.sawyer.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyDAO fanDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Family> findbyemp(int emp_ID) {
        return fanDAO.findbyemp(emp_ID);
    }

    @Override
    public void add(Family fan) {
        fanDAO.add(fan);
    }

    @Override
    public void delete(int relation_ID) {
        fanDAO.delete(relation_ID);
    }

    @Override
    public void update(Family fan) {
        fanDAO.update(fan);
    }
}