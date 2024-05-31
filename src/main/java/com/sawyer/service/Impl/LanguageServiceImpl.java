package com.sawyer.service.Impl;

import com.sawyer.dao.LanguageDAO;

import com.sawyer.entity.Language;

import com.sawyer.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDAO lanDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Language> findbyemp(int emp_ID) {
        return lanDAO.findbyemp(emp_ID);
    }

    @Override
    public void add(Language lan) {
        lanDAO.add(lan);
    }

    @Override
    public void delete(int language_ID) {
        lanDAO.delete(language_ID);
    }

    @Override
    public void update(Language lan) {
        lanDAO.update(lan);
    }
}