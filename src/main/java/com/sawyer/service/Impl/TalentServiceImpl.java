package com.sawyer.service.Impl;

import com.sawyer.dao.TalentDAO;
import com.sawyer.entity.Talentpool;
import com.sawyer.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class TalentServiceImpl implements TalentService {

    @Autowired
    private TalentDAO talDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Talentpool> findAll() {
        return talDAO.findAll();
    }

    @Override
    public void add(Talentpool tal) {
        talDAO.add(tal);
    }

    @Override
    public void delete(int id) {
        talDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Talentpool findbyID(int id) {
        return talDAO.findbyID(id);
    }


}
