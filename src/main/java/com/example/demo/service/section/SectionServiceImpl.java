package com.example.demo.service.section;

import com.example.demo.model.Section;
import com.example.demo.repository.SectionRepository;
import com.example.demo.service.section.interfaces.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    SectionRepository sectionRepository;

    @Override
    public Section insert(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public Section update(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    public void delete(int id) {
         sectionRepository.deleteById(id);
    }

    @Override
    public Section getSectionById(int id) {
        return sectionRepository.findById(id).get();
    }

    @Override
    public Section getSectionByName(String name) {
        return null;
    }

    @Override
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }
}
