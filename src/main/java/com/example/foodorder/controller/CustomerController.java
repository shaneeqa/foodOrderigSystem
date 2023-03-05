package com.example.foodorder.controller;

import com.example.foodorder.service.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
}
