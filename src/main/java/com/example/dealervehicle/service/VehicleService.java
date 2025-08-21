package com.example.dealervehicle.service;

import com.example.dealervehicle.model.Dealer;
import com.example.dealervehicle.model.Vehicle;
import com.example.dealervehicle.repository.DealerRepository;
import com.example.dealervehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final DealerRepository dealerRepository;

    public VehicleService(VehicleRepository vehicleRepository, DealerRepository dealerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.dealerRepository = dealerRepository;
    }

    public List<Vehicle> getAllVehicles() { return vehicleRepository.findAll(); }

    public Optional<Vehicle> getVehicleById(Long id) { return vehicleRepository.findById(id); }

    public Vehicle saveVehicle(Long dealerId, Vehicle vehicle) {
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found"));
        vehicle.setDealer(dealer);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setStatus(vehicleDetails.getStatus());
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) { vehicleRepository.deleteById(id); }

    public List<Vehicle> getVehiclesOfPremiumDealers() {
        return vehicleRepository.findVehiclesOfPremiumDealers();
    }
}