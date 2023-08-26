package com.example.demo.controller;

import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class homeController {
    @Autowired
    ProductRepo productRepo;
    @GetMapping("/homepage")
    public String homepage(Model model){
        model.addAttribute("product1",productRepo.findAll());
        return "/home";
    }
    @GetMapping("/detail/{id}")
    public String deatil(Model model, @PathVariable Optional<Long> id){
        model.addAttribute("product12",productRepo.getOne(id.get()));
        return "/productDetail";
    }
    @GetMapping("/search")
    public String searchProduct(@RequestParam("name") String name, Model model){
        model.addAttribute("product123",productRepo.getAllProductByName(name));
        return "/searchProduct";
    }
    @GetMapping("/homepage1)
    public String homepage1(){
        return "";
    }
     @GetMapping("/homepage2)
    public String homepage2(){
        return "";
    }
      @GetMapping("/homepage3)
    public String homepage3(){
        return "";
    }
       @GetMapping("/homepage5)
    public String homepage5(){
        return "12333433333";
    }
}
