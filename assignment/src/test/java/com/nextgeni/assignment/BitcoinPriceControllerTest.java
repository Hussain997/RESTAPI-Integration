package com.nextgeni.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BitcoinPriceControllerTest {

	 @Mock
	    private BitcoinPriceService bitcoinPriceService;

	    @Mock
	    private RestTemplate restTemplate;

	    @InjectMocks
	    private BitcoinPriceController bitcoinPriceController;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void testFetchBitcoinPrice_Success() {
	        String jsonResponse = "{ \"time\": { \"updatedISO\": \"2023-01-01T00:00:00Z\" }, \"bpi\": { \"USD\": { \"code\": \"USD\", \"symbol\": \"$\", \"rate\": \"34,000.00\", \"description\": \"United States Dollar\", \"rate_float\": 34000.00 }, \"GBP\": { \"code\": \"GBP\", \"symbol\": \"£\", \"rate\": \"25,000.00\", \"description\": \"British Pound Sterling\", \"rate_float\": 25000.00 }, \"EUR\": { \"code\": \"EUR\", \"symbol\": \"€\", \"rate\": \"30,000.00\", \"description\": \"Euro\", \"rate_float\": 30000.00 } } }";
	        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonResponse, HttpStatus.OK);

	        when(restTemplate.getForEntity(any(String.class), eq(String.class))).thenReturn(responseEntity);

	        ResponseEntity<?> response = bitcoinPriceController.fetchBitcoinPrice();

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        verify(bitcoinPriceService, times(3)).saveBitcoinPrice(any(BitcoinPrice.class));
	    }


	    @Test
	    void testGetBitcoinPrices() {
	        BitcoinPrice bitcoinPrice = new BitcoinPrice();
	        bitcoinPrice.setCode("USD");
	        bitcoinPrice.setRate("34,000.00");

	        when(bitcoinPriceService.getAllBitcoinPrices()).thenReturn(Collections.singletonList(bitcoinPrice));

	        ResponseEntity<List<BitcoinPrice>> response = bitcoinPriceController.getBitcoinPrices();

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(1, response.getBody().size());
	        assertEquals("USD", response.getBody().get(0).getCode());
	    }

}