package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.resturant;
import com.foodie.resturants.Repositries.resturantsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class resturantServices {

    @Autowired
    private resturantsrepo  resturantsRepo;

    public resturant UserSave(resturantdto resturantDTO){
      return resturantsRepo.save(convertDtoToEntity(resturantDTO));

    }
    public resturant convertDtoToEntity(resturantdto resturantDTO){

        resturant resturant = new resturant();

        resturant.setId(resturantDTO.getId());
        resturant.setName(resturantDTO.getName());
        resturant.setEmail(resturantDTO.getEmail());
        resturant.setPassword(resturantDTO.getPassword());
        resturant.setPhone(resturantDTO.getPhone());
        resturant.setAddress(resturantDTO.getAddress());
        resturant.setCity(resturantDTO.getCity());
        resturant.setState(resturantDTO.getState());
        resturant.setZip(resturantDTO.getZip());
        resturant.setCountry(resturantDTO.getCountry());
        resturant.setMenu(resturantDTO.getMenu());

        return resturant;
    }
}
