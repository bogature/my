package com.example.demo.service.group;

import com.example.demo.model.Groups;
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
    public Groups insert(Groups groups) {
        return groupRepository.save(groups);
    }

    @Override
    public Groups update(Groups groups) {
        return groupRepository.save(groups);
    }

    @Override
    public void delete(int id) {
         groupRepository.deleteById(id);
    }

    @Override
    public Groups getGroupById(int id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public Groups getGroupByName(String name) {
        return null;
    }

    @Override
    public List<Groups> getAll() {
        return groupRepository.findAll();
    }
}
