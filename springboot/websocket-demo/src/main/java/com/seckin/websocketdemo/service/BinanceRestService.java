package com.seckin.websocketdemo.service;

import com.seckin.websocketdemo.model.TradeViaHttpsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceRestService {

    @Value("${binance.rest.url}")
    private String binanceRestUrl;

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 10000)
    public String poll(){
        TradeViaHttpsDto result = restTemplate.getForObject(binanceRestUrl, TradeViaHttpsDto.class);
        System.err.println(result);
        return result.toString();
    }


}
