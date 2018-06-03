package com.seckin.websocketdemo.service;

import com.seckin.websocketdemo.model.TradeViaWssDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MarketWebSocketService {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @EventListener
    public void receive(TradeViaWssDto tradeViaWssDto){
        System.err.println("Event received: " + tradeViaWssDto.toString());
        //TODO : inspect next line
        //simpMessagingTemplate.convertAndSend("changes", tradeViaWssDto);
    }

}
