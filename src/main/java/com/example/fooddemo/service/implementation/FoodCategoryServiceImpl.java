package com.example.fooddemo.service.implementation;

import com.example.fooddemo.model.FoodCategory;
import com.example.fooddemo.repository.FoodCategoryRepository;
import com.example.fooddemo.service.FoodCategoryService;

import java.util.List;

public class FoodCategoryServiceImpl implements FoodCategoryService {
    private FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }

    @Override
    public List<FoodCategory> getAllCategories() {
        return foodCategoryRepository.findAll();
    }
}
