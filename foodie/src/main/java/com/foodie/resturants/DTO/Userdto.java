package com.foodie.resturants.DTO;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userdto {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}
