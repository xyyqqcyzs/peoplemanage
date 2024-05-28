package com.sawyer.service;

import com.sawyer.dao.EmpDAO;
import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

}
