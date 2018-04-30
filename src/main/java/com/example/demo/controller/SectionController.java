package com.example.demo.controller;

import com.example.demo.model.Section;
import com.example.demo.service.section.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionServiceImpl sectionService;

    @PostMapping("/insert")
    public Section insertSection( @RequestBody Section section){
        return sectionService.insert(section);
    }

    @PostMapping("/update")
    public Section updateSection(@RequestBody Section section,@RequestParam("id") int id) {
        section.setId(id);
        return sectionService.update(section);
    }

    @GetMapping("/getById")
    public Section getSectionById(@RequestParam ("id") int id){
        return sectionService.getSectionById(id);
    }

    @DeleteMapping("/delete")
    public void deleteSection(@RequestParam ("id") int id){
        sectionService.delete(id);
    }
    @GetMapping("/getAll")
    public List<Section> getAllSection(){
        return sectionService.getAll();
    }
}
