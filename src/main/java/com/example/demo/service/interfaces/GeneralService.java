package com.example.demo.service.interfaces;

import java.util.List;

public interface GeneralService<T> {
    //public  <T> insert();
//    public  <T> update();
//    public  <T> delete();
    public List<T> getAll();
}
