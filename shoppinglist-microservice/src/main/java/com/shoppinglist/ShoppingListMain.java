package com.shoppinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShoppingListMain {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListMain.class, args);

    }
}
