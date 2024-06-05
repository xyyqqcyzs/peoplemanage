package com.sawyer.service.Impl;

import com.sawyer.dao.DimissionDAO;
import com.sawyer.entity.Dimission;


import com.sawyer.service.DimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.Date;

@Service
@Transactional
public class DimServiceImpl implements DimService {

    @Autowired
    private DimissionDAO dimissionDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findAll() {return dimissionDAO.findAll();}

    @Override
    public void add(Dimission dim) {dimissionDAO.add(dim);}

    @Override
    public void delete(int id) {dimissionDAO.delete(id);}

    @Override
    public void update(Dimission dim) {dimissionDAO.update(dim);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Dimission findbyID(int emp_ID) {return dimissionDAO.findbyID(emp_ID);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Dimission findbyemp(int emp_ID) {return dimissionDAO.findbyemp(emp_ID);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findbypos(int pos_ID) {return dimissionDAO.findbypos(pos_ID);}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Dimission> findbydep(int dep_ID) {return dimissionDAO.findbydep(dep_ID);}

    @Override
    public List<Dimission> findByDateRange(Date startDate, Date endDate) {
//        if (startDate == null && endDate != null) {
//            startDate = new Date(0); // 设置为最小日期
//        } else if (endDate == null && startDate != null) {
//            endDate =  new Date(); // 设置为当前日期
//        } else if (startDate == null && endDate == null) {
//            return dimissionDAO.findAll();
//        } else
//            return dimissionDAO.findByDateRange(startDate, endDate);

        return dimissionDAO.findByDateRange(startDate, endDate);
    }
}
