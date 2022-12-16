package com.cargo.service;

import com.cargo.model.Courier;
import com.cargo.model.Packages;

import java.util.List;

public interface PackagesService {



    Packages create(Integer width, Integer height, Integer depth, Integer weight, Courier courier);
    List<Packages> listAll();
    Packages update();
    Packages delete();
}
