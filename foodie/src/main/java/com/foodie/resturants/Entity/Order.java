package com.foodie.resturants.Entity;

import com.foodie.resturants.Enum.orderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    List<orderItem>  orderItems;

}
