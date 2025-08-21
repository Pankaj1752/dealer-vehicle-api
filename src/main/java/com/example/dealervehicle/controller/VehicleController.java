package com.example.dealervehicle.controller;

import com.example.dealervehicle.model.Vehicle;
import com.example.dealervehicle.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() { return vehicleService.getAllVehicles(); }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @PostMapping("/dealer/{dealerId}")
    public Vehicle createVehicle(@PathVariable Long dealerId, @RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(dealerId, vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) { vehicleService.deleteVehicle(id); }

    @GetMapping("/premium")
    public List<Vehicle> getVehiclesOfPremiumDealers() {
        return vehicleService.getVehiclesOfPremiumDealers();
    }
}