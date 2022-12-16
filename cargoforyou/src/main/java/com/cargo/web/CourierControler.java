package com.cargo.web;

import com.cargo.model.Courier;
import com.cargo.model.Packages;
import com.cargo.model.Price;
import com.cargo.service.PackagesService;
import com.cargo.service.impl.CourierServiceimpl;
import com.cargo.service.impl.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourierControler {
    private final CourierServiceimpl courierServiceimpl;
    private final PriceService priceService;
    private final PackagesService packagesService;
    public CourierControler(CourierServiceimpl courierServiceimpl, PriceService priceService, PackagesService packagesService) {
        this.courierServiceimpl = courierServiceimpl;
        this.priceService = priceService;
        this.packagesService = packagesService;
    }

    @GetMapping({"/","/couriers"})
    public String showCouriers( @RequestParam (required = false) String name,@RequestParam (required = false) Integer width,
            @RequestParam (required = false) Integer height,@RequestParam (required = false) Integer depth,@RequestParam (required = false) Integer weight, Model model) {
        float cost;
        String error=null;
        if (name!=null && width!=null && height!=null && depth!=null && weight!=null){
        Long id=this.courierServiceimpl.findByName(name).getId();
        error=this.courierServiceimpl.validate(id,width,height,depth,weight);
        Courier courier=this.courierServiceimpl.findById(id);
        if (error==null) {
            List<Price> prices = this.priceService.listAllByCourierId(id);
            cost = this.priceService.calculatePrice(id, width, height, depth, weight);
            Packages packages=this.packagesService.create(width, height, depth, weight,courier);
            model.addAttribute("cost", cost);

        }}
        List<Courier> couriers=this.courierServiceimpl.listAll();
        model.addAttribute("couriers",couriers);
        model.addAttribute("error", error);
        return "listCouriersAndPriceCheck.html";
    }
    /*@GetMapping({"/","/couriers"})public String showCouriers(  Model model) {
        List<Courier> couriers=this.courierServiceimpl.listAll();
        model.addAttribute("couriers",couriers);

        return "listCouriersAndPriceCheck.html";
    }*/


}
