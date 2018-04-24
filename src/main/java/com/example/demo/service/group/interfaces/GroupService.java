package com.example.demo.service.group.interfaces;

import com.example.demo.model.Group;
import com.example.demo.model.Tourist;

import java.util.List;

public interface GroupService {
    public Group insert(Group group);
    public Group update(Group group);
    public Group delete(int id);
    public Group getGroupById(int id);
    public Group getGroupByName(String name);
    public List<Group> getAll();
}
