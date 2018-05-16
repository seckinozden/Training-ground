package com.seckin.luckyapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class LuckyService {

    @Value("${luckyapp.number}")
    private int luckyNumber;

    public int printLuckyNumber() {
        return luckyNumber;
    }
}
