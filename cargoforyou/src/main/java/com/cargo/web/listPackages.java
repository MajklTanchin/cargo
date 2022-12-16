package com.cargo.web;

import com.cargo.model.Courier;
import com.cargo.model.Packages;
import com.cargo.service.impl.PackagesServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class listPackages {
private final PackagesServiceImpl packagesService;

    public listPackages(PackagesServiceImpl packagesService) {
        this.packagesService = packagesService;
    }

    @GetMapping({"/couriers/packages"})
    public String listPackages(Model model){
        List<Packages> packages=this.packagesService.listAll();
        model.addAttribute("pack",packages);

        return "listPackages.html";
    }
}
