package com.cargo.service.impl;

import com.cargo.model.Courier;
import com.cargo.model.exceptions.invalidCourieridException;
import com.cargo.repository.CourierRepository;
import com.cargo.service.CourierService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cargo.service.impl.Calculate.calculateCubicMeters;
@Service
public class CourierServiceimpl implements CourierService {
    private final CourierRepository courierRepository;

    public CourierServiceimpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public Courier create(String name, Integer validKgLow, Integer validKgHigh, Integer validDimensionsLow, Integer validDimensionsHigh) {

        Courier courier= new Courier( name,  validKgLow,  validKgHigh,validDimensionsLow, validDimensionsHigh);

        return this.courierRepository.save(courier);
    }

    @Override
    public Courier findByName(String name) {
        return listAll().stream().filter(r->r.getName().equals(name)).findFirst().orElseThrow(invalidCourieridException::new);
    }

    public Courier findById(Long id) {
        return this.courierRepository.findById(id).orElseThrow(invalidCourieridException:: new);
    }


    @Override
    public List<Courier> listAll() {
        return courierRepository.findAll();
    }
    public String validate(Long id,Integer width, Integer height,Integer depth,Integer weight ){
        Courier courier=findById(id);
        long dimension= calculateCubicMeters(width,height,depth);
        if(courier.getValidKgLow()>weight||courier.getValidKgHigh()<weight  ){
            return "this cargo can't transfer your parcel.It is overweight ";
        }
        else if (courier.getValidDimensionsLow()>dimension||courier.getValidDimensionsHigh()<dimension  ){
            return "this cargo can't transfer your parcel.It is above specified dimensions";

        }

        else return null ;
    }

}
