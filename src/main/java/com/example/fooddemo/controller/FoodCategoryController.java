package com.example.fooddemo.controller;

import com.example.fooddemo.model.FoodCategory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class FoodCategoryController {

    @GetMapping("/addcategory")
    public String createCategory(Model model){
        FoodCategory foodCategory = new FoodCategory();
        model.addAttribute("category", foodCategory);
        return "addCategory";
    }
}
