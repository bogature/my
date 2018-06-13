package com.example.demo.service.group.interfaces;

import com.example.demo.model.Groups;

import java.util.List;

public interface GroupService {
    Groups insert(Groups groups);
    Groups update(Groups groups);
    void delete(int id);
    Groups getGroupById(int id);
    Groups getGroupByName(String name);
    List<Groups> getAll();

}
