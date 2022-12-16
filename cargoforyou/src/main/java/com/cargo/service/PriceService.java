package com.cargo.service;

import com.cargo.model.Courier;
import com.cargo.model.Price;

import java.util.List;

public interface PriceService {

    List<Price> listAll ();
    Price create(String basedOn,  Integer lowerValue,  Integer higherValue, float cost,Courier courier);

}
