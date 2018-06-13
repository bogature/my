package com.example.demo.repository;

import com.example.demo.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepository extends JpaRepository<Tourist,Integer> {

//    Req 1
    @Query(" select tour from Tourist tour  where  tour.groups.id = :group_id")
    List<Tourist> getTouristByGroup(@Param("group_id") int group_id);

//    Req 2
    @Query(" select count (tour) from Tourist tour  where  tour.groups.id = :group_id")
    int getCountTouristByGroup(@Param("group_id") int group_id);

//    Req 3
    @Query(" select tour from Tourist tour  where  tour.typeOfTourist > :type_id")
    List<Tourist> getTouristByType(@Param("type_id") int type_id);

//    Req 4
    @Query(" select count (tour) from Tourist tour where tour.age > :age")
    int getCountTouristByAge(@Param("age") int age);

//    Req 5
    @Query(" select tour from Tourist tour  where  tour.age > :age")
    List<Tourist> getTouristByAge(@Param("age") int age);

}
