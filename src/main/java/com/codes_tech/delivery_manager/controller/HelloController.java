package com.codes_tech.delivery_manager.controller;

import com.codes_tech.delivery_manager.model.User;
import com.codes_tech.delivery_manager.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
 
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "hello";
    }
}
