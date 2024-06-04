package com.sawyer.service.Impl;


import com.sawyer.dao.EmpmovDAO;
import com.sawyer.dao.HolidayDAO;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Holiday;
import com.sawyer.service.EmpmovService;
import com.sawyer.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayDAO holDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Holiday> findAll() {
        return holDAO.findAll();
    }

    @Override
    public void add(Holiday hol) {
        holDAO.add(hol);
    }

    @Override
    public void delete(int hol_ID) {
        holDAO.delete(hol_ID);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Holiday> findbyemp(int emp_ID) {
        return holDAO.findbyemp(emp_ID);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Holiday> findbyprocess(String process_state) {
        return holDAO.findbyprocess(process_state);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Holiday findbyID(int id) {
        return holDAO.findbyID(id);
    }

    @Override
    public void update(Holiday hol) {
        holDAO.update(hol);
    }

}