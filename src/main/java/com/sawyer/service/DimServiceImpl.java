package com.sawyer.service;

import com.sawyer.dao.DimissionDAO;
import com.sawyer.entity.Dimission;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.Date;

@Service
@Transactional
public class DimServiceImpl implements DimService{

    @Autowired
    private DimissionDAO dimissionDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findAll() {return dimissionDAO.findAll();}

    //@Override
    //public void add(int emp_ID, Date dim_date, String dim_reason) {dimissionDAO.add(emp_ID,dim_date,dim_reason);}

    @Override
    public void deleteEmployee(int id) {dimissionDAO.deleteEmployee(id);}

    @Override
    public void delete(int id) {dimissionDAO.delete(id);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Dimission findbyID(int emp_ID) {return dimissionDAO.findbyID(emp_ID);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findbypos(int pos_ID) {return dimissionDAO.findbypos(pos_ID);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findbydep(int dep_ID) {return dimissionDAO.findbydep(dep_ID);}

    @Override
    public List<Dimission> findByDateRange(Date startDate, Date endDate) {
        return dimissionDAO.findByDateRange(startDate, endDate);
    }
}


