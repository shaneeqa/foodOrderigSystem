package com.example.foodorder.model;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name="order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="line_number")
    private Long lineNumber;

    @OneToOne
    @JoinColumn(name="item_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    @Column(name="quantity")
    private Integer quantity;

    public OrderLine() {
    }

    public OrderLine(FoodItem foodItem, Order order, Integer quantity) {
        this.foodItem = foodItem;
        this.order = order;
        this.quantity = quantity;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
