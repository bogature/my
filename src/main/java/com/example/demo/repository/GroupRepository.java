package com.example.demo.repository;

import com.example.demo.model.Groups;
import com.example.demo.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Groups,Integer> {
    //    Req 7
    @Query("select gro from Groups gro where gro.section.id = :id")
    List<Groups> getGroupsBySection(@Param("id") int id);

    //    Req 8
    @Query("select count(gro)from Groups gro where gro.section.id = :id")
    int getCountGroupsBySection(@Param("id") int id);

    //    Req 9
    @Query("select gro from Groups gro where gro.coach.id = :id")
    List<Groups> getGroupsByCoach(@Param("id") int id);

    //    Req 10
    @Query("select count(gro) from Groups gro where gro.coach.id = :id")
    int getCountGroupsByCoach(@Param("id") int id);
}
