package com.sawyer.service;

import com.sawyer.dao.EmpDAO;
import com.sawyer.dao.EmpmovDAO;
import com.sawyer.dao.PositionDAO;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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


}