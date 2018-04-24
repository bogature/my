package com.example.demo.service.schedule;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.schedule.interfaces.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule insert(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule update(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void delete(int id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule getScheduleById(int id) {
        return scheduleRepository.findById(id).get();
    }

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }
}
