package com.example.foodorder.model;

import jakarta.persistence.*;

@Entity
@Table(name="food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long itemId;
    @Column(name="item_name")
    private String itemName;
    @Column(name="item_description")
    private String itemDescription;
    @Column(name="item_price")
    private Float itemPrice;
    @Column(name="availability")
    private boolean availability;
    //image
    @ManyToOne
    @JoinColumn(name="category_id")
    private FoodCategory foodCategory;

    @OneToOne(mappedBy = "foodItem", cascade = CascadeType.ALL)
    private OrderLine orderLine;


    public FoodItem() {
    }

    public FoodItem(String itemName, String itemDescription, Float itemPrice, boolean availability,
                    FoodCategory foodCategory, OrderLine orderLine) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.availability = availability;
        this.foodCategory = foodCategory;
        this.orderLine = orderLine;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
}
