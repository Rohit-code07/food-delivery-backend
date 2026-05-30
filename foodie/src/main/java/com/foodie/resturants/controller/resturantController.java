package com.foodie.resturants.controller;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Services.IMPL.resturantServicesimpl;
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

    private resturantServicesimpl resturantServices1;

    public resturantController(resturantServicesimpl ResturantServices) {
       this.resturantServices1= ResturantServices;
    }

    @PostMapping
    public ResponseEntity<resturantdto> creatResturant(@RequestBody  resturantdto resturantDTO) {
       resturantServices1.saveResturant(resturantDTO);
        return ResponseEntity.ok(resturantDTO);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<resturantdto>> FindAll(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                             @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                              @RequestParam(value="sortBy",required = false,defaultValue = "name")String sortBy,
                                              @RequestParam(value = "sortDir",required = false,defaultValue ="desc")String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);

      return ResponseEntity.ok(resturantServices1.getResturants(pageable));

    }
    @GetMapping("/AllResturant/{resturantName}")
    public ResponseEntity<Page<resturantdto>> getResturantByName(
            @RequestParam(value = "page",required = false,defaultValue = "0")int page,
            @RequestParam(value="size",required = false,defaultValue = "10")int size,
            @RequestParam(value="sortDir",required = false,defaultValue = "asc")String sortDir,
            @RequestParam(value="sortBy",required = false,defaultValue = "name")String sortBy,
            @PathVariable String resturantName) {
         Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
         Pageable pageable= PageRequest.of(page, size,sort);
         Page<resturantdto> restaurantDTOs = resturantServices1.searchResturantByName(pageable,resturantName);

        return ResponseEntity.ok(restaurantDTOs);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<resturantdto> delete(@PathVariable long id){

       resturantdto dto= resturantServices1.findById(id);
        resturantServices1.deleteResturantById(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<resturantdto> updateResturant(@RequestBody resturantdto dto) {
        resturantServices1.updateResturant(dto);
        return ResponseEntity.ok(dto);
    }
}
