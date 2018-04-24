package com.example.demo.service.section.interfaces;

import com.example.demo.model.Section;

import java.util.List;

public interface SectionService {
    public Section insert(Section section);
    public Section update(Section section);
    public void delete(int id);
    public Section getSectionById(int id);
    public Section getSectionByName(String name);
    public List<Section> getAll();
}
