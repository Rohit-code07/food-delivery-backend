package com.foodie.resturants.Services;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public Page<Userdto> findAllUsers(Pageable pageable);
    public Page<Userdto> getUsersByUserName(String username,Pageable pageable);

}
