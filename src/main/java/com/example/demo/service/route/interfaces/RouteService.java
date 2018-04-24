package com.example.demo.service.route.interfaces;

import com.example.demo.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RouteService {
    public Route insert(Route route);
    public Route update(Route route);
    public void delete(int id);
    public Route getRouteById(int id);
    public Route getRouteByName(String name);
    public List<Route> getAll();
}
