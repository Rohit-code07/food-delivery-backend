package com.foodie.resturants.Services.IMPL;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Repositries.Userrepo;
import com.foodie.resturants.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceimpl implements UserService {
    @Autowired
    private Userrepo userrepo;

    public Userdto UserSave(Userdto userdto){
       User saveUser=userrepo.save(convertDtoToEntity(userdto));
       return convertEntityToDto(saveUser);
    }

// User Save
    @Override
    public void save(User user) {
        userrepo.save(user);
    }
// Update User
    @Override
    public void update(User user) {
   userrepo.save(user);
    }

// Delete User
    @Override
    public void delete(User user) {
      userrepo.delete(user);
    }

//Find All User
    @Override
    public Page<Userdto> findAllUsers(Pageable pageable) {

      Page<User> user1=userrepo.findAll(pageable);
        return user1.map(this::convertEntityToDto);

    }
//Get User by name
    @Override
    public Page<Userdto> getUsersByUserName(String username, Pageable pageable) {
        Page<User> NamedUser=userrepo.findByName(username,pageable);
        return NamedUser.map(this::convertEntityToDto);
    }
// DTO -> Entity
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



// Entity -> DTO
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
