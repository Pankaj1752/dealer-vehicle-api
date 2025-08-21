package com.example.dealervehicle.repository;

import com.example.dealervehicle.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
