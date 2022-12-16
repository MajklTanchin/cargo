package com.cargo.service;

import com.cargo.model.Courier;

import java.util.List;

public interface CourierService {


    Courier create(String name, Integer validKgLow, Integer validKgHigh, Integer validDimensionsLow, Integer validDimensionsHigh);
    Courier findByName(String name);
    Courier findById(Long id);
    List <Courier> listAll ();

}
