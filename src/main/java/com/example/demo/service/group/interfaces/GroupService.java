package com.example.demo.service.group.interfaces;

import com.example.demo.model.Groups;

import java.util.List;

public interface GroupService {
    public Groups insert(Groups groups);
    public Groups update(Groups groups);
    public void delete(int id);
    public Groups getGroupById(int id);
    public Groups getGroupByName(String name);
    public List<Groups> getAll();
}
