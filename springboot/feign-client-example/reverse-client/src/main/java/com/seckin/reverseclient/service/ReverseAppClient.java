package com.seckin.reverseclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("reverseApp")
public interface ReverseAppClient {

    @GetMapping("/reverse/{value}")
    String reverse(@PathVariable("value") String value);
}
