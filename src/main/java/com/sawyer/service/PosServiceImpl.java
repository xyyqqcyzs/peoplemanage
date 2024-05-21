package com.sawyer.service;

import com.sawyer.dao.DepartmentDAO;
import com.sawyer.dao.PositionDAO;
import com.sawyer.entity.Department;
import com.sawyer.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PosServiceImpl implements PosService {

    @Autowired
    private PositionDAO posDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Position> findAll() {
        return posDAO.findAll();
    }

    @Override
    public void add(Position pos) {
        posDAO.add(pos);
    }

    @Override
    public void delete(int id) {
        posDAO.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Position findbyID(int id) {
        return posDAO.findbyID(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Position> findbydep(int dep_id) {
        return posDAO.findbydep(dep_id);
    }

    @Override
    public void update(Position pos) {
        posDAO.update(pos);
    }
}