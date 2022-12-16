package com.cargo.service.impl;

import com.cargo.model.Courier;
import com.cargo.model.Packages;
import com.cargo.repository.PackagesRepository;
import com.cargo.service.PackagesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackagesServiceImpl implements PackagesService {
private final PackagesRepository packagesRepository;

    public PackagesServiceImpl(PackagesRepository packagesRepository) {
        this.packagesRepository = packagesRepository;
    }

    @Override
    public Packages create(Integer width, Integer height, Integer depth, Integer weight, Courier courier) {
        Packages packages=new Packages(width,height,depth,weight,courier);
        return this.packagesRepository.save(packages);
    }

    @Override
    public List<Packages> listAll() {
        List<Packages> packages=this.packagesRepository.findAll();
        return packages;
    }

    @Override
    public Packages update() {
        return null;
    }

    @Override
    public Packages delete() {
        return null;
    }
}
