package com.example.demo.service.schedule.interfaces;

import com.example.demo.model.Schedule;

import java.util.List;

public interface ScheduleService {
    public Schedule insert(Schedule schedule);
    public Schedule update(Schedule schedule);
    public void delete(int id);
    public Schedule getScheduleById(int id);
    //public Schedule getScheduleBySection(String section);
    public List<Schedule> getAll();
}
