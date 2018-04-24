package com.example.demo.model;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.Gender;
import com.example.demo.enums.TypeOfTourist;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Group group;
    @Enumerated(EnumType.STRING)
    private TypeOfTourist typeOfTourist;
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    public Tourist() {
    }

    public Tourist(String name, int age, Gender gender, LocalDate dateOfBirth, Group group, TypeOfTourist typeOfTourist, DifficultyLevel difficultyLevel) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.group = group;
        this.typeOfTourist = typeOfTourist;
        this.difficultyLevel = difficultyLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TypeOfTourist getTypeOfTourist() {
        return typeOfTourist;
    }

    public void setTypeOfTourist(TypeOfTourist typeOfTourist) {
        this.typeOfTourist = typeOfTourist;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
