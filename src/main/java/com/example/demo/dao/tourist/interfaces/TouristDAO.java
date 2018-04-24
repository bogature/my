package com.example.demo.dao.tourist.interfaces;

import com.example.demo.model.Tourist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TouristDAO {
    public Tourist insert(Tourist tourist);
    public Tourist update(int id);
    public Tourist delete(int id);
    public List<Tourist> getAll() throws SQLException, IOException;
}
