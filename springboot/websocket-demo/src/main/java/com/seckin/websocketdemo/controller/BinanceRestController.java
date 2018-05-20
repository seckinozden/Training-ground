package com.seckin.websocketdemo.controller;

import com.seckin.websocketdemo.service.BinanceRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Service automatically polls the latest price information, because it is already scheduled.
 * This controller is for getting prices manually and letting outer world to use the service.
 */
@RestController
@RequestMapping("prices")
public class BinanceRestController {

    @Autowired
    private BinanceRestService binanceRestService;

    @GetMapping("ping")
    public String triggerServicePoll() {
        return binanceRestService.poll();
    }
}
