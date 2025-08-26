package com.thinuka.SwagHouse_backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/get")
    public String test(){
        return "Hello World";
    }
}
