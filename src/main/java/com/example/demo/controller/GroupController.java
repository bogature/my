package com.example.demo.controller;

import com.example.demo.model.Group;
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
    public Group insertGroup( @RequestBody Group group){
        return groupService.insert(group);
    }

    @PostMapping("/update")
    public Group updateGroup(@RequestBody  Group group){
        return groupService.update(group);
    }

    @GetMapping("/getById")
    public Group getGroupById(@RequestParam ("id") int id){
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/delete")
    public void deleteGroup(@RequestParam ("id") int id){
        groupService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Group> getAllGroups(){
        return groupService.getAll();
    }
}
