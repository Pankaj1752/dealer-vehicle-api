package com.example.dealervehicle.repository;

import com.example.dealervehicle.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> { }