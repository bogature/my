package com.example.demo.repository;

import com.example.demo.model.Section;
import com.example.demo.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {
}
