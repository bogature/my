package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.service.group.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GroupController {
    @Autowired
    GroupServiceImpl groupService;

    @GetMapping("/getAllGroups")
    public List<Group> getAllGroups(){
        return groupService.getAll();
    }
}
