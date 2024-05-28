package com.sawyer.service.Impl;

import com.sawyer.dao.EmpDAO;
import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDAO empDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findAll() {
        return empDAO.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findbypos(int pos_id) {
        return empDAO.findbypos(pos_id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findbydep(int dep_id) {
        return empDAO.findbydep(dep_id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findbyMode(String mode) {
        return empDAO.findbyMode(mode);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findbyemptype(String emp_type) {
        return empDAO.findbyemptype(emp_type);
    }
    @Override
    public void add(Employee emp) {
        empDAO.add(emp);
    }

    @Override
    public void delete(int id) {
        empDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employee findbyID(int id) {
        return empDAO.findbyID(id);
    }

    @Override
    public void update(Employee emp) {
        empDAO.update(emp);
    }

    @Override
    public Career findcareer(int id){return empDAO.findcareer(id);}

    @Override
    public List<Employee> findbyall(Integer dep_ID, Integer pos_ID, Date datea, Date dateb,String entermode, String emp_type, Date confirm_datea,  Date confirm_dateb,String intern_situation){
        return empDAO.findbyall(dep_ID,pos_ID,datea,dateb,entermode,emp_type,confirm_datea,confirm_dateb,intern_situation);
    };

}
