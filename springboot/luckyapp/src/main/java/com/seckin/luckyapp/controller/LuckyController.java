package com.seckin.luckyapp.controller;

import com.seckin.luckyapp.service.LuckyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("api/v1")
public class LuckyController {

    @Autowired
    private LuckyService luckyService;

    @GetMapping("/myLuckyNumber")
    public String printMyLuckyNumber() {
        int number = luckyService.printLuckyNumber();
        return "Your lucky number is: " + number;
    }
}