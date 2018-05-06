package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.service.route.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    RouteServiceImpl routeService;

    @PostMapping("/insert")
    public Route insertRoute( @RequestBody Route route){
        return routeService.insert(route);
    }

    @PostMapping("/update")
    public Route updateRoute(@RequestBody Route route,@RequestParam("id") int id) {
        route.setId(id);
        return routeService.update(route);
    }

    @GetMapping("/getById")
    public Route getRouteById(@RequestParam ("id") int id){
        return routeService.getRouteById(id);
    }

    @DeleteMapping("/delete")
    public void deleteRoute(@RequestParam ("id") int id){
        routeService.delete(id);
    }


    @GetMapping("/getAll")
    public List<Route> getAllRoutes(){
        return routeService.getAll();
    }
}
