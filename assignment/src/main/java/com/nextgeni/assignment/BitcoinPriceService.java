package com.nextgeni.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitcoinPriceService {
    @Autowired
    private BitcoinPriceRepository repository;

    public void saveBitcoinPrice(BitcoinPrice bitcoinPrice) {
        repository.save(bitcoinPrice);
    }

    public List<BitcoinPrice> getAllBitcoinPrices() {
        return repository.findAll();
    }
}