package com.foodie.resturants.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class FoodItemdto {
    private String name;
    private String description;
    private String image;
    private String price;
    private Integer quantity;
    private BigDecimal weight;
    private BigDecimal availableQuantity;
    private String Unit;
    private String variationName;
}
