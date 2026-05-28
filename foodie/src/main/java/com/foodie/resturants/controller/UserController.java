package com.foodie.resturants.controller;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@RequestMapping("/api/v1/user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Userdto> createUser(@RequestBody Userdto userDTO){
         userService.UserSave(userDTO);
         return ResponseEntity.ok(userDTO);
    }

}
