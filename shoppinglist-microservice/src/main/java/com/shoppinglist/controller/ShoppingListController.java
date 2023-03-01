package com.shoppinglist.controller;

import com.shoppinglist.configuration.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class ShoppingListController {

    @Autowired
    private AppConfig config;

    @GetMapping("/message")
    public String hello() {
        return config.getMessage();
    }

    @GetMapping
    public Iterable<String> getShoopingList() {
        return Arrays.asList("chicken", "apple" , "pineouts" , "pig");
    }
}
