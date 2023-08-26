package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class productController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping({"/products", "/edit/{id}"})
    public String listProducts(Model model, @PathVariable Optional<Long> id){
        model.addAttribute("products",productRepo.findAll());
        model.addAttribute("product", new Product());
        if(id.isPresent()){
            model.addAttribute("product",productRepo.getOne(id.get()));
        }
        return "/product";
    }
    @PostMapping("/products/save")
    public String saveProducts(@ModelAttribute("product") Product product){
        productRepo.save(product);
        return "redirect:/homepage";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productRepo.delete(id);
        return "redirect:/homepage";
    }

}
