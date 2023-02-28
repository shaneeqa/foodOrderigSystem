package com.example.foodorder.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="food_category")
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="availability")
    private boolean availability;
    //image
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems = new ArrayList<>();

    public FoodCategory() {
    }

    public FoodCategory(String categoryName, boolean availability, List<FoodItem> foodItems) {
        this.categoryName = categoryName;
        this.availability = availability;
        this.foodItems = foodItems;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
