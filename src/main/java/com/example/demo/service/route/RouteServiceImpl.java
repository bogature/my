package com.example.demo.service.route;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.service.route.interfaces.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    RouteRepository routeRepository;

    @Override
    public Route insert(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route update(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void delete(int id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Route getRouteById(int id) {
        return routeRepository.findById(id).get();
    }

    @Override
    public Route getRouteByName(String name) {
        return null;
    }

    @Override
    public List<Route> getAll() {
        return routeRepository.findAll();
    }

}
