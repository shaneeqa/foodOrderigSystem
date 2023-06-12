package com.example.fooddemo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long orderId;
    @Column(name="order_date")
    private Date orderDate;
    @Column(name="total_price")
    private Float totalPrice;
    @Column(name="order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="customer_id"/*, referencedColumnName = "customerId"*/)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();


}
