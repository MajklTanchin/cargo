package com.cargo.repository;

import com.cargo.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackagesRepository extends JpaRepository<Packages,Long> {
}
