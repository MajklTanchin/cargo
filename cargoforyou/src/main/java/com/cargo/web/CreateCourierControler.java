package com.cargo.web;

import com.cargo.model.Courier;
import com.cargo.model.Price;
import com.cargo.service.impl.CourierServiceimpl;
import com.cargo.service.impl.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateCourierControler {
    private  final CourierServiceimpl courierServiceimpl;
    private  final PriceService priceService;

    public CreateCourierControler(CourierServiceimpl courierServiceimpl, PriceService priceService) {
        this.courierServiceimpl = courierServiceimpl;

        this.priceService = priceService;
    }

    @GetMapping({"/couriers/create"})
    public String createCourier(
            //Courier
            @RequestParam (required = false)String name, @RequestParam (required = false)Integer validKgLow,
            @RequestParam (required = false) Integer validKgHigh,@RequestParam (required = false) Integer validDimensionsLow,
            @RequestParam (required = false) Integer validDimensionsHigh
            //Price
            , @RequestParam (required = false)String basedOn, @RequestParam (required = false)Integer lowerValue,
            @RequestParam (required = false) Integer higherValue,@RequestParam (required = false) Integer cost,
            @RequestParam (required = false) String courierName
            , Model model) {
        //Check input for courier
        if (name!=null && validKgLow!=null && validKgHigh!=null && validDimensionsLow!=null && validDimensionsHigh!=null) {
            Courier courier = this.courierServiceimpl.create(name, validKgLow, validKgHigh, validDimensionsLow, validDimensionsHigh);
        }//Check input for price
        if (basedOn!=null&&lowerValue!=null&&higherValue!=null&&cost!=null&&courierName!=null){
            Long id=this.courierServiceimpl.findByName(courierName).getId();
            Courier courier=this.courierServiceimpl.findById(id);
            Price price=this.priceService.create(basedOn,lowerValue,higherValue,cost,courier);
        }
        List<Price> prices=this.priceService.listAll();
        List<Courier> couriers=this.courierServiceimpl.listAll();
        model.addAttribute("price",prices);
        model.addAttribute("couriers",couriers);
        return "createCourier.html";
    }

    /*@GetMapping({"/couriers/create/price"})
    //String basedOn,  Integer lowerValue,  Integer higherValue, float cost,Courier couriers
    public String showPrices(@RequestParam (required = false)String basedOn, @RequestParam (required = false)Integer lowerValue,
                               @RequestParam (required = false) Integer higherValue
            ,@RequestParam (required = false) Integer cost,@RequestParam (required = false) String courierName, Model model) {
        Long id=this.courierServiceimpl.findByName(courierName).getId();
        Courier courier=this.courierServiceimpl.findById(id);

        Price price=this.priceService.create(basedOn,lowerValue,higherValue,cost,courier);
        List<Price> prices=this.priceService.listAll();
        model.addAttribute("price",prices);

        return "createCourier.html";
    }*/

}
