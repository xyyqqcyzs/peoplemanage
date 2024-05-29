package com.sawyer.service.Impl;


import com.sawyer.dao.EmpmovDAO;
import com.sawyer.entity.Employeemov;
import com.sawyer.service.EmpmovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class EmpmovServiceImpl implements EmpmovService {

    @Autowired
    private EmpmovDAO movDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employeemov> findAll() {
        return movDAO.findAll();
    }

    @Override
    public void add(Employeemov mov) {
        movDAO.add(mov);
    }

    @Override
    public void delete(int mov_ID) {
        movDAO.delete(mov_ID);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employeemov> findbyemp(int emp_ID) {
        return movDAO.findbyemp(emp_ID);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employeemov> findbytype(String movtype) {
        return movDAO.findbytype(movtype);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employeemov> findby(Integer emp_ID,Date datea, Date dateb,String movtype, String process_state) {
        return movDAO.findby(emp_ID,datea,dateb,movtype,process_state);
    }

    @Override
    public void update(Employeemov mov) {
        movDAO.update(mov);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employeemov findbyID(int id) {
        return movDAO.findbyID(id);
    }
}