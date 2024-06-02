package com.nextgeni.assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coindesk")
@Validated
public class BitcoinPriceController {
    @Autowired
    private BitcoinPriceService service;

    @GetMapping("/fetch-data")
    public ResponseEntity<?> fetchBitcoinPrice() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = new JSONObject(response.getBody());
            JSONObject time = jsonObject.getJSONObject("time");
            String updatedTimeStr = time.getString("updatedISO");
            LocalDateTime updatedTime = LocalDateTime.parse(updatedTimeStr, DateTimeFormatter.ISO_DATE_TIME);

            JSONObject bpi = jsonObject.getJSONObject("bpi");

            Iterator<String> keys = bpi.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject currency = bpi.getJSONObject(key);
                BitcoinPrice bitcoinPrice = new BitcoinPrice();
                bitcoinPrice.setCode(currency.getString("code"));
                bitcoinPrice.setSymbol(currency.getString("symbol"));
                bitcoinPrice.setRate(currency.getString("rate"));
                bitcoinPrice.setDescription(currency.getString("description"));
                bitcoinPrice.setRateFloat(currency.getDouble("rate_float"));
                bitcoinPrice.setUpdatedTime(updatedTime);
                service.saveBitcoinPrice(bitcoinPrice);
            }
            return ResponseEntity.ok("Data saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch data");
        }
    }

    @GetMapping("/bitcoin-prices")
    public ResponseEntity<List<BitcoinPrice>> getBitcoinPrices() {
        return ResponseEntity.ok(service.getAllBitcoinPrices());
    }

}