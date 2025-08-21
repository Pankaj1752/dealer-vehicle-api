package com.example.dealervehicle.service;

import com.example.dealervehicle.model.Dealer;
import com.example.dealervehicle.repository.DealerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {

    private final DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    public List<Dealer> getAllDealers() { return dealerRepository.findAll(); }

    public Dealer getDealerById(Long id) {
        return dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id " + id));
    }

    public Dealer saveDealer(Dealer dealer) { return dealerRepository.save(dealer); }

    public Dealer updateDealer(Long id, Dealer dealerDetails) {
        Dealer dealer = getDealerById(id);
        dealer.setName(dealerDetails.getName());
        dealer.setEmail(dealerDetails.getEmail());
        dealer.setSubscriptionType(dealerDetails.getSubscriptionType());
        return dealerRepository.save(dealer);
    }

    public void deleteDealer(Long id) {
        Dealer dealer = getDealerById(id);
        dealerRepository.delete(dealer);
    }
}