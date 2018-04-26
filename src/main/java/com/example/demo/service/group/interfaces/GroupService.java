package com.example.demo.service.group.interfaces;

import com.example.demo.model.Group;

import java.util.List;

public interface GroupService {
    public Group insert(Group group);
    public Group update(Group group);
    public void delete(int id);
    public Group getGroupById(int id);
    public Group getGroupByName(String name);
    public List<Group> getAll();
}
