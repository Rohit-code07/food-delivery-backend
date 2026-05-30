package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.resturant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface resturantServices {

    public Page<resturantdto> getResturants(Pageable pageable);
    public resturantdto saveResturant(resturantdto resturantDto);
    public void deleteResturantById(long id);
    public void updateResturant(resturantdto resturantDto);
    public Page<resturantdto> searchResturantByName(Pageable pageable, String resturantName);

}
