package com.demo.retoApi.controller;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @Autowired
    private PersonService userService;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Person> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

}
