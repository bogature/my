package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.service.route.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    RouteServiceImpl routeService;

    @GetMapping("/getAllRoutes")
    public List<Route> getAllRoutes(){
        return routeService.getAll();
    }
}
