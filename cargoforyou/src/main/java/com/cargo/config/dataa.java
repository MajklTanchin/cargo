package com.cargo.config;

import com.cargo.model.Courier;
import com.cargo.model.Role;
import com.cargo.model.User;
import com.cargo.service.impl.CourierServiceimpl;
import com.cargo.service.impl.PriceService;
import com.cargo.service.impl.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component

public class dataa {

private final PriceService priceService;
private  final CourierServiceimpl courierServiceimpl;
private  final UserServiceImpl userService;
    public static final String ADMIN = "admin";
    public dataa(PriceService priceService, CourierServiceimpl courierServiceimpl, UserServiceImpl userService) {
        this.priceService = priceService;
        this.courierServiceimpl = courierServiceimpl;
        this.userService = userService;
    }


    @PostConstruct
        public void initData() {
            Courier courier=this.courierServiceimpl.create("Cargo4You",  0,  20, 0, 2000);
            User admin = this.userService.create(ADMIN, ADMIN, Role.ROLE_ADMIN);
            this.priceService.create("dimensions", 0, 1000, 10,courier);
            this.priceService.create("dimensions", 1000, 2000, 20,courier);
            Courier courierr=this.courierServiceimpl.create("ShipFaster",  10,  30, 0, 1700);
            this.priceService.create("dimensions", 0, 1000, (float) 11.99,courierr);
            this.priceService.create("dimensions", 1000, 1700, (float) 21.99,courierr);


    }

}
