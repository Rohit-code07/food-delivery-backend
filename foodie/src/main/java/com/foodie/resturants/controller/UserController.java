package com.foodie.resturants.controller;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Userdto createUser(@RequestBody Userdto userDTO){
         userService.UserSave(userDTO);
         return  new Userdto();
    }

}
