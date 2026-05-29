package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.resturant;
import com.foodie.resturants.Repositries.resturantsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class resturantServices {

    @Autowired
    private resturantsrepo  resturantsRepo;

    public resturantdto UserSave(resturantdto resturantDTO){
      resturant saveResturant= resturantsRepo.save(convertDtoToEntity(resturantDTO));
      return convertEntityToDto(saveResturant);

    }

    public Page<resturantdto> getAll(Pageable pageable) {

        Page<resturant> resturants = resturantsRepo.findAll(pageable);

        return resturants.map(this::convertEntityToDto);
    }

    public List<resturantdto> getResturantByName(String resturantName) {

       List <resturant> restaurant = resturantsRepo.findByName(resturantName);

        List<resturantdto> dtos = restaurant.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());


        return dtos;
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
    public resturantdto convertEntityToDto(resturant resturant) {

        resturantdto resturantDTO = new resturantdto();

        resturantDTO.setId(resturant.getId());
        resturantDTO.setName(resturant.getName());
        resturantDTO.setEmail(resturant.getEmail());
        resturantDTO.setPassword(resturant.getPassword());
        resturantDTO.setPhone(resturant.getPhone());
        resturantDTO.setAddress(resturant.getAddress());
        resturantDTO.setCity(resturant.getCity());
        resturantDTO.setState(resturant.getState());
        resturantDTO.setZip(resturant.getZip());
        resturantDTO.setCountry(resturant.getCountry());
        resturantDTO.setMenu(resturant.getMenu());

        return resturantDTO;
    }


}
