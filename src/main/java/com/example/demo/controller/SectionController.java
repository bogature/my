package com.example.demo.controller;

import com.example.demo.model.Section;
import com.example.demo.service.section.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionController {
    @Autowired
    SectionServiceImpl sectionService;
    @GetMapping("/getAllSections")
    public List<Section> getAllSection(){
        return sectionService.getAll();
    }
}
