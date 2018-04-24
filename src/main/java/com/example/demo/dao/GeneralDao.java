package com.example.demo.dao;

import java.util.List;

public interface GeneralDao<T> {
    public  T insert();
    public  T update();
    public  T delete();
    public List<T> getAll();


}
