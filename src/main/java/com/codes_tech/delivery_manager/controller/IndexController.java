package com.codes_tech.delivery_manager.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/panel")
    public String hello(Model model) {
        return "panel";
    }
}
