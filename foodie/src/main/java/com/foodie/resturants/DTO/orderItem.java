package com.foodie.resturants.DTO;

import com.foodie.resturants.Entity.FoodItem;
import com.foodie.resturants.Entity.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class orderItem {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "FoodItem_id")
    private FoodItem foodItem;
    private String Unit;
    private BigDecimal price;
}
