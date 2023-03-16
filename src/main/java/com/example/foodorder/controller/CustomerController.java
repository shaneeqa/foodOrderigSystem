package com.example.foodorder.controller;

import com.example.foodorder.model.Customer;
import com.example.foodorder.service.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/customers/new")
    public String createCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "newCustomer";
    }

    @PostMapping("/addcustomer")
    public String saveCustomer(@ModelAttribute ("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{customerId}")
    public String editCustomer(@PathVariable Long customerId, Model model){
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "editCustomer";
    }

    @PostMapping("/customer/{customerId}")
    public String updateCustomer(@PathVariable Long customerId,
                                 @ModelAttribute("customer") Customer customer,
                                 Model model){
        Customer existingCustomerValue = customerService.getCustomerById(customerId);
        existingCustomerValue.setCustomerId(customerId);
        existingCustomerValue.setCustomerName(customer.getCustomerName());
        existingCustomerValue.setCustomerAddress(customer.getCustomerAddress());
        existingCustomerValue.setTelephone(customer.getTelephone());

        customerService.updateCustomer(existingCustomerValue);

        return "redirect:/customers";
    }

    @GetMapping("/customers/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
        return "redirect:/customers";
    }
}
