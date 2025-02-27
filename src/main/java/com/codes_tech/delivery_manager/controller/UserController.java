package com.codes_tech.delivery_manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codes_tech.delivery_manager.model.User;
import com.codes_tech.delivery_manager.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "user/index";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newRender(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String insert(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user";
    }
}
