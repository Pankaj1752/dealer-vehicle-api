package com.example.dealervehicle.controller;

import com.example.dealervehicle.model.Payment;
import com.example.dealervehicle.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public Payment initiatePayment(@RequestParam Long dealerId,
                                   @RequestParam Double amount,
                                   @RequestParam String method) {
        return paymentService.initiatePayment(dealerId, amount, method);
    }
}