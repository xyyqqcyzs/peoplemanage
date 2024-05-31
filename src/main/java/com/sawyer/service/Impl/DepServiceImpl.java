package com.sawyer.service.Impl;

import com.sawyer.dao.DepartmentDAO;
import com.sawyer.entity.Department;

import com.sawyer.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DepServiceImpl implements DepService {

    @Autowired
    private DepartmentDAO depDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> findAll() {
        return depDAO.findAll();
    }

    @Override
    public void add(Department dep) {
        depDAO.add(dep);
    }

    @Override
    public void delete(int id) {
        depDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Department find(int id) {
        return depDAO.find(id);
    }

    @Override
    public void update(Department dep) {
        depDAO.update(dep);
    }
}