package com.sawyer.dao;

import com.sawyer.entity.Position;

import java.util.List;



public interface PositionDAO {
    List<Position> findAll();

    void add(Position pos);

    void delete(int id);

    Position findbyID(int id);

    void update(Position pos);
    List<Position> findbydep(int dep_id);

}
