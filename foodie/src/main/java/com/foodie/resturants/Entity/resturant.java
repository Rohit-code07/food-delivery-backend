package com.foodie.resturants.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String country;
    private boolean OpenNow;
    private LocalTime OpenTime;
    private LocalTime CloseTime;
    private String image;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User ADMIN;
    @OneToMany
    private List<FoodItem> foodItems;


}
