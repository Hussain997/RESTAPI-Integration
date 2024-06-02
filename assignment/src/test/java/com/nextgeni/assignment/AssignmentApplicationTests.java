package com.nextgeni.assignment;


import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {

    @Mock
    private BitcoinPriceRepository repository;

    @InjectMocks
    private BitcoinPriceService service;

    @Test
    public void testSaveBitcoinPrice() {
        BitcoinPrice bitcoinPrice = new BitcoinPrice();
        bitcoinPrice.setCode("USD");
        bitcoinPrice.setSymbol("$");
        bitcoinPrice.setRate("34,000.00");
        bitcoinPrice.setDescription("United States Dollar");
        bitcoinPrice.setRateFloat(34000.00);
        bitcoinPrice.setUpdatedTime(LocalDateTime.now());

        service.saveBitcoinPrice(bitcoinPrice);

        verify(repository, times(1)).save(bitcoinPrice);
    }

}
