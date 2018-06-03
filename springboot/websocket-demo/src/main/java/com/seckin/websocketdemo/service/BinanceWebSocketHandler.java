package com.seckin.websocketdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seckin.websocketdemo.model.TradeViaWssDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;

@Service
public class BinanceWebSocketHandler implements WebSocketHandler {

    @Value("${binance.wss.url}")
    private String binanceWssUrl;

    @Autowired
    private WebSocketClient webSocketClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostConstruct
    public void init() {
        webSocketClient.doHandshake(this, binanceWssUrl);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        //System.err.println(webSocketSession);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        String payload = (String) webSocketMessage.getPayload();
        //System.err.println(payload);

        TradeViaWssDto trade = objectMapper.readValue(payload, TradeViaWssDto.class);
        publisher.publishEvent(trade);// we publish an event
        //System.err.println(trade);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        //System.err.println(webSocketSession);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        //System.err.println(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
