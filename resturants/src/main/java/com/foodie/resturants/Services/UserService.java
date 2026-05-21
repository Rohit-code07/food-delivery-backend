package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Repositries.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;

public  class UserService {
    @Autowired
    private Userrepo userrepo;

    public Userdto Usersave(Userdto userdto){
       return userrepo.save(convertDtoToEntity(userdto));
    }

    public User convertDtoToEntity(Userdto userDTO){

         User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setZip(userDTO.getZip());
        user.setCountry(userDTO.getCountry());

        return user;
    }
}
