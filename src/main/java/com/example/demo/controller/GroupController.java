package com.example.demo.controller;

import com.example.demo.model.Groups;
import com.example.demo.service.group.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupServiceImpl groupService;


    @PostMapping("/insert")
    public Groups insertGroup(@RequestBody Groups groups){
        return groupService.insert(groups);
    }

    @PostMapping("/update")
    public Groups updateGroup(@RequestBody Groups groups, @RequestParam("id") int id){
        groups.setId(id);
        return groupService.update(groups);
    }

    @GetMapping("/getById")
    public Groups getGroupById(@RequestParam ("id") int id){
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/delete")
    public void deleteGroup(@RequestParam ("id") int id){
        groupService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Groups> getAllGroups(){
        return groupService.getAll();
    }
}
