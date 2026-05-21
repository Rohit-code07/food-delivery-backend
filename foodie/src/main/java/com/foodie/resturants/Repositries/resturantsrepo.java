package com.foodie.resturants.Repositries;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Entity.resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface resturantsrepo extends JpaRepository<User,Long> {
     public resturantdto save(resturant resturant);
    public resturant findByUsername(String username);
    public resturant findByEmail(String email);
    public List<resturant> findByResturantId(Long resturantId);
    public List<resturant> findByUserId(Long userId);
}
