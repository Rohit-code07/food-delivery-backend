package com.foodie.resturants.DTO;

import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Entity.orderItem;
import com.foodie.resturants.Entity.resturant;
import com.foodie.resturants.Enum.orderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "resturant_id")
    private resturant Resturant;
    private BigDecimal Totalprice;
    @Enumerated(EnumType.STRING)
    private orderStatus orderStatus;
    @CreationTimestamp
    private LocalDateTime OrderTime;
    @OneToMany(mappedBy = "orderItem",cascade = CascadeType.ALL,orphanRemoval = true)
    List<orderItem> orderItems;

}
