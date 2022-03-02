package com.example.aopdemo.aopdemoapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author heior
 */
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "hello " + name;
    }


    @GetMapping("/cas")
    public String hello2(@RequestParam("name") String name, @RequestParam("age") String age) {
        return "hello " + name + age;
    }
}
