package com.example.demo.service.group;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.group.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group insert(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(int id) {
         groupRepository.deleteById(id);
    }

    @Override
    public Group getGroupById(int id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Group getGroupByName(String name) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }
}
