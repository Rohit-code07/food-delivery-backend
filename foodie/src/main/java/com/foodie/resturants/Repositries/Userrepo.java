package com.foodie.resturants.Repositries;

import com.foodie.resturants.DTO.Userdto;
import com.foodie.resturants.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepo extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User save(User user);

    public User deleteById(long id);
}
