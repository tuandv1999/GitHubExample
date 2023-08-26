package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class uersController {
    @Autowired
    UserRepo userRepo;

    @GetMapping({"/users", "/user/edit/{id}"})
    public String listProducts(Model model, @PathVariable Optional<Long> id){
        model.addAttribute("users",userRepo.findAll());
        model.addAttribute("user", new User());
        if(id.isPresent()){
            model.addAttribute("user",userRepo.getOne(id.get()));
        }
        return "/user";
    }
    @PostMapping("/user/save")
    public String saveProducts(@ModelAttribute("user") User user){
        userRepo.save(user);
        return "redirect:/homepage";
    }
}
