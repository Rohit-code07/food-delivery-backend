package com.foodie.resturants.Repositries;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Userrepo extends JpaRepository<User,Long> {
    public User findByemail(String email);
    public Userdto save(User user);
}
