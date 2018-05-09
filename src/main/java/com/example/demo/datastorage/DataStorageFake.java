package com.example.demo.datastorage;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.Gender;
import com.example.demo.enums.TypeOfInstructor;
import com.example.demo.model.*;
import com.example.demo.model.Groups;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.enums.DifficultyLevel.EASY;
import static com.example.demo.enums.DifficultyLevel.MIDDLE;
import static com.example.demo.enums.TypeOfTour.NOPLAN;
import static com.example.demo.enums.TypeOfTour.PLAN;
import static com.example.demo.enums.TypeOfTourist.ATHLETE;

@Configuration
public class DataStorageFake {
    LocalDate localDate=LocalDate.of(1,1,1);
    LocalTime localTime=LocalTime.of(1,1);
    LoadLevel loadLevel=new LoadLevel();
    Manager manager=new Manager(1,"Andriy",1,localDate,20);
    Section section=new Section(1,"A",manager);
    Coach coach=new Coach(1,"Alex",2,3,section,loadLevel);
    Groups groups =new Groups(1,"143",section,coach);
    Instructor instructor=new Instructor(1,"Roma", TypeOfInstructor.COACH, MIDDLE);
    Competition competition=new Competition(1,"Champion",localDate);
    Schedule schedule=new Schedule(1,section,5,"Kobylanska 17",localTime);
    Route route=new Route(1,"Goverla",3000);
    Checkpoint checkpoint=new Checkpoint(1,"L",route);
    //Tour tour=new Tour("A", groups,instructor,MIDDLE,5,localTime,PLAN,route);

    List<Tourist> tourists = new ArrayList<>(Arrays.asList(
            new Tourist("sasha", 18, Gender.MALE, localDate, groups, ATHLETE, DifficultyLevel.HARD),
            new Tourist("roma", 18, Gender.MALE, localDate, groups, ATHLETE, DifficultyLevel.HARD),
            new Tourist("nazar", 18, Gender.MALE, localDate, groups, ATHLETE, DifficultyLevel.HARD),
            new Tourist("kolya", 19, Gender.MALE, localDate, groups, ATHLETE, DifficultyLevel.HARD),
            new Tourist("scheva", 20, Gender.MALE, localDate, groups, ATHLETE, DifficultyLevel.HARD)
    ));
    List<Groups> groups1 = new ArrayList<>(Arrays.asList(
            new Groups(1, "143", section, coach),
            new Groups(2, "142", section, coach),
            new Groups(3, "141", section, coach)
    ));
    List<Manager> managers = new ArrayList<>(Arrays.asList(
            new Manager(1, "Andriy", 1, localDate, 20),
            new Manager(2, "B", 1, localDate, 20),
            new Manager(3, "C", 1, localDate, 20)
    ));
    List<Section> sections = new ArrayList<>(Arrays.asList(
            new Section(1, "A", manager),
            new Section(2, "B", manager),
            new Section(3, "C", manager)
    ));
    List<Coach> coaches = new ArrayList<>(Arrays.asList(
            new Coach(1, "Alex", 2, 3, section, loadLevel),
            new Coach(2, "A", 2, 3, section, loadLevel),
            new Coach(3, "B", 2, 3, section, loadLevel)
    ));
    List<Instructor> instructors = new ArrayList<>(Arrays.asList(
            new Instructor(1, "Roma", TypeOfInstructor.COACH, MIDDLE),
            new Instructor(2, "A", TypeOfInstructor.COACH, MIDDLE),
            new Instructor(3, "B", TypeOfInstructor.COACH, MIDDLE)
    ));
    List<Competition> competitions = new ArrayList<>(Arrays.asList(
            new Competition(1, "Champion", localDate),
            new Competition(2, "A", localDate),
            new Competition(3, "B", localDate)
    ));
    List<Route> routes = new ArrayList<>(Arrays.asList(
            new Route(1, "Goverla", 3000),
            new Route(2, "A", 3000),
            new Route(3, "B", 3000)
    ));
    List<Schedule> schedules = new ArrayList<>(Arrays.asList(
            new Schedule(1, section, 5, "Kobylanska 17", localTime),
            new Schedule(2, section, 5, "Kobylanska 15", localTime),
            new Schedule(3, section, 5, "Kobylanska 21", localTime)
    ));
    List<Checkpoint> checkpoints = new ArrayList<>(Arrays.asList(
            new Checkpoint(1, "L", route),
            new Checkpoint(2, "S", route),
            new Checkpoint(3, "R", route)
    ));
//    List<Tour> tours = new ArrayList<>(Arrays.asList(
//            new Tour( "A", groups, instructor, MIDDLE, 5, localTime, PLAN, route),
//            new Tour( "B", groups, instructor, EASY, 8, localTime, NOPLAN, route),
//            new Tour( "C", groups, instructor, MIDDLE, 5, localTime, PLAN, route)
//    ));


//    public List<Tourist> getTourists() {
//        return tourists;
//    }
//
//    public void setTourists(List<Tourist> tourists) {
//        this.tourists = tourists;
//    }
//
//    public List<Groups> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(List<Groups> groups) {
//        this.groups = groups;
//    }
//
//    public List<Manager> getManagers() {
//        return managers;
//    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }
//
//    public List<Tour> getTours() {
//        return tours;
//    }
//
//    public void setTours(List<Tour> tours) {
//        this.tours = tours;
//    }
}
