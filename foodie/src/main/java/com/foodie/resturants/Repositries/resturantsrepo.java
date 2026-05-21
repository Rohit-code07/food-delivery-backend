package com.foodie.resturants.Repositries;

import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Entity.resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface resturantsrepo extends JpaRepository<User,Long> {

    public resturant save(resturant resturant);


}
