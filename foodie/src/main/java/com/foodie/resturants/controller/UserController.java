package com.foodie.resturants.controller;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Services.IMPL.UserServiceimpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequestMapping("/api/v1/user")
public class UserController {


    private UserServiceimpl userService;

    public UserController(UserServiceimpl userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Userdto> createUser(@RequestBody Userdto userDTO){
         userService.UserSave(userDTO);
         return ResponseEntity.ok(userDTO);
    }
    @DeleteMapping
    public ResponseEntity<Userdto> deleteUser(@RequestBody Userdto userDTO){
        userService.delete(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping
    public ResponseEntity<Userdto> updateUser(@RequestBody Userdto userDTO){
        userService.update(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Userdto>> getAllUsers(
            @RequestParam(value = "page",required = false,defaultValue = "0")int page,
            @RequestParam(value="size",required = false,defaultValue = "10")int size,
            @RequestParam(value="sortDir",required = false,defaultValue = "asc")String sortDir,
            @RequestParam(value="sortBy",required = false,defaultValue = "name")String sortBy

    ){
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page, size,sort);
       Page<Userdto> userdto= userService.findAllUsers(pageable);
        return ResponseEntity.ok(userdto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Page<Userdto>> getUser(
            @PathVariable String username,
            @RequestParam(value = "page",required = false,defaultValue = "0")int page,
            @RequestParam(value="size",required = false,defaultValue = "10")int size,
            @RequestParam(value="sortDir",required = false,defaultValue = "asc")String sortDir,
            @RequestParam(value="sortBy",required = false,defaultValue = "name")String sortBy
                                           ){
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page, size,sort);
        Page<Userdto> userdtos=userService.getUsersByUserName(username,pageable);

        return ResponseEntity.ok(userdtos);
    }

}
