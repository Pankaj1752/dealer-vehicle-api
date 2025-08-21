package com.example.dealervehicle.repository;

import com.example.dealervehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealerId(Long dealerId);

    @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = com.example.dealervehicle.model.SubscriptionType.PREMIUM")
    List<Vehicle> findVehiclesOfPremiumDealers();
}