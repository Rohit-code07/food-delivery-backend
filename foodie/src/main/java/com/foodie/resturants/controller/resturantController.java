package com.foodie.resturants.controller;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.resturant;
import com.foodie.resturants.Services.UserService;
import com.foodie.resturants.Services.resturantServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resturant")
public class resturantController {

    private resturantServices resturantServices1;

    public resturantController(resturantServices ResturantServices) {
       this.resturantServices1= ResturantServices;
    }

    @PostMapping
    public ResponseEntity<resturantdto> creatResturant(@RequestBody  resturantdto resturantDTO) {
       resturantServices1.UserSave(resturantDTO);
        return ResponseEntity.ok(resturantDTO);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<resturantdto>> FindAll(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                             @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                              @RequestParam(value="sortBy",required = false,defaultValue = "name")String sortBy,
                                              @RequestParam(value = "sortDir",required = false,defaultValue ="desc")String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);

      return ResponseEntity.ok(resturantServices1.getAll(pageable));

    }
    @GetMapping("/AllResturant/{resturantName}")
    public ResponseEntity<List<resturantdto>> getResturantServices1(
            @PathVariable String resturantName) {

        List<resturantdto> restaurantDTOs =
                resturantServices1.getResturantByName(resturantName);

        return ResponseEntity.ok(restaurantDTOs);
    }
}
