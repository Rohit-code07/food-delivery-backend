package com.foodie.resturants.Services.IMPL;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.resturant;
import com.foodie.resturants.Repositries.resturantsrepo;
import com.foodie.resturants.Services.resturantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class resturantServicesimpl implements resturantServices {

    @Autowired
    private resturantsrepo  resturantsRepo;



//Save
    public resturantdto saveResturant(resturantdto resturantDTO) {
        resturant saveResturant = resturantsRepo.save(convertDtoToEntity(resturantDTO));
        return convertEntityToDto(saveResturant);

    }

// resturant BY id
public  resturantdto findById(long id) {
      resturant resturant1=  resturantsRepo.findById(id);
      return convertEntityToDto(resturant1);
}

//Delete Resturant
    @Override
    public void deleteResturantById(long id) {
        resturantsRepo.deleteById(id);
    }

//Get Resturants
    @Override
    public Page<resturantdto> getResturants(Pageable pageable) {

        Page<resturant> resturants = resturantsRepo.findAll(pageable);

        return resturants.map(this::convertEntityToDto);
    }
// Resturant Search By name
    public Page<resturantdto> searchResturantByName(Pageable pageable,String resturantName) {

      Page<resturant> restaurant = resturantsRepo.findByName(pageable,resturantName);

        return restaurant.map(this::convertEntityToDto);
    }
// Update Resturant
    @Override
    public void updateResturant(resturantdto resturantDto) {
        resturantsRepo.save(convertDtoToEntity(resturantDto));
    }


// DTO -> Entity
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

// Entity -> DTO
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
