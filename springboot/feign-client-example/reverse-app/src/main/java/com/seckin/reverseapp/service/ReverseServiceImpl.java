package com.seckin.reverseapp.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseServiceImpl implements ReverseService {

    @Override
    public String getReverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
