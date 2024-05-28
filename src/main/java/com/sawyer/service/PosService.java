package com.sawyer.service;

import com.sawyer.entity.Department;
import com.sawyer.entity.Position;

import java.util.List;

public interface PosService {
    List<Position> findAll();

    void add(Position pos);

    void delete(int id);

    Position findbyID(int id);

    void update(Position pos);
    List<Position> findbydep(int dep_id);
}
