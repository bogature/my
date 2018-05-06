package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.service.schedule.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleServiceImpl scheduleService;

    @PostMapping("/insert")
    public Schedule insertSchedule( @RequestBody Schedule schedule){
        return scheduleService.insert(schedule);
    }

    @PostMapping("/update")
    public Schedule updateSchedule(@RequestBody Schedule schedule,@RequestParam("id") int id) {
        schedule.setId(id);
        return scheduleService.update(schedule);
    }

    @GetMapping("/getById")
    public Schedule getScheduleById(@RequestParam ("id") int id){
        return scheduleService.getScheduleById(id);
    }

    @DeleteMapping("/delete")
    public void deleteSchedule(@RequestParam ("id") int id){
        scheduleService.delete(id);
    }


    @GetMapping("/getAll")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAll();
    }
}
