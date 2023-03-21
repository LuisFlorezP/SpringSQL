package com.example.SpringSQL.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;

@RestController
public class Page {

    public Page() {
    }

    @GetMapping("/menu")
    public String Menu() {
        Scanner sc = new Scanner(System.in);

        return "";
    }
}
