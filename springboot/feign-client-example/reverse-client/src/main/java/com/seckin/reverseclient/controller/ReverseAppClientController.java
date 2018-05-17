package com.seckin.reverseclient.controller;

import com.seckin.reverseclient.service.ReverseAppClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reverse")
public class ReverseAppClientController {

    @Autowired
    private ReverseAppClient reverseAppClient;

    @GetMapping("{value}")
    public String reverseString(@PathVariable String value) {
        return reverseAppClient.reverse(value);
    }
}
