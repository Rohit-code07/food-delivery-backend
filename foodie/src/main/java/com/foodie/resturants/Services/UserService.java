package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Repositries.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserService {
    @Autowired
    private Userrepo userrepo;

    public Userdto UserSave(Userdto userdto){
       User saveUser=userrepo.save(convertDtoToEntity(userdto));
       return convertEntityToDto(saveUser);
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

    public Userdto convertEntityToDto(User user) {

        Userdto userDTO = new Userdto();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setState(user.getState());
        userDTO.setZip(user.getZip());
        userDTO.setCountry(user.getCountry());

        return userDTO;
    }
}
