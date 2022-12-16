package com.cargo.repository;

import com.cargo.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier,Long> {

}
