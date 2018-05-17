package com.seckin.reverseapp.controller;

import com.seckin.reverseapp.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reverse")
public class ReverseController {

    @Autowired
    ReverseService reverseService;

    @RequestMapping("{value}")
    public String printReverse(@PathVariable String value) {
        return reverseService.getReverse(value);
    }
}
