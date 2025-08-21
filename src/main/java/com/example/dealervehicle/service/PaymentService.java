package com.example.dealervehicle.service;

import com.example.dealervehicle.model.Payment;
import com.example.dealervehicle.repository.PaymentRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment initiatePayment(Long dealerId, Double amount, String method) {
        Payment payment = new Payment();
        payment.setDealerId(dealerId);
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        Payment savedPayment = paymentRepository.save(payment);
        simulateCallback(savedPayment.getId());
        return savedPayment;
    }

    @Async
    public CompletableFuture<Void> simulateCallback(Long paymentId) {
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        payment.setStatus("SUCCESS");
        payment.setUpdatedAt(LocalDateTime.now());
        paymentRepository.save(payment);
        return CompletableFuture.completedFuture(null);
    }
}