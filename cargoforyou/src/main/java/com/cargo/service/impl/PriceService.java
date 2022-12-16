package com.cargo.service.impl;

import com.cargo.model.Courier;
import com.cargo.model.Price;
import com.cargo.model.exceptions.invalidCourieridException;
import com.cargo.repository.CourierRepository;
import com.cargo.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cargo.service.impl.Calculate.calculateCubicMeters;

@Service
public class PriceService implements com.cargo.service.PriceService {
private final PriceRepository priceRepository;
private final CourierRepository courierRepository;

    public PriceService(PriceRepository priceRepository, CourierRepository courierRepository) {
        this.priceRepository = priceRepository;
        this.courierRepository = courierRepository;
    }


    @Override
    public List<Price> listAll() {
        return priceRepository.findAll();
    }
    public List<Price> listAllByCourierId(Long id){
        List<Price> prices= listAll();
        List<Price> prices1 =new ArrayList<>();
        for(int i=0;i<prices.size();i++) {
            if (prices.get(i).getCouriers().getId() == id) {
                prices1.add(prices.get(i));
                System.out.print(prices1);
            }

        }

        return prices1 ;
    }

    @Override
    public Price create(String basedOn,  Integer lowerValue,  Integer higherValue, float cost,Courier couriers) {
        Price price=new Price( basedOn, lowerValue, higherValue, cost,couriers);
        return this.priceRepository.save(price) ;
    }

public Float calculatePrice(Long id,Integer width, Integer height,Integer depth,Integer weight ){
        List<Price>prices=listAllByCourierId(id);
        float priceForWeight=0;
        float priceForDimensions=0;
        float cost=0;
        Integer dimension=calculateCubicMeters(width,height,depth);
        for (int i=0;i<prices.size();i++){

            if (prices.get(i).getBasedOn()=="weight"&&prices.get(i).getLowerValue()<weight&&weight<prices.get(i).getHigherValue()){
                priceForWeight=prices.get(i).getCost();

            }
            else if (prices.get(i).getBasedOn()=="dimensions"&&prices.get(i).getLowerValue()<dimension&&dimension<prices.get(i).getHigherValue()){
                priceForDimensions=prices.get(i).getCost();

            }
        }
        if (priceForDimensions>priceForWeight)
        {
            cost=priceForDimensions;
        }
        else cost=priceForDimensions;
        return cost;
}



}
