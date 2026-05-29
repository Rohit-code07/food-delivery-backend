package com.foodie.resturants.Repositries;

import com.foodie.resturants.DTO.resturantdto;
import com.foodie.resturants.Entity.User;
import com.foodie.resturants.Entity.resturant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface resturantsrepo extends JpaRepository<resturant,Long> {

    public resturant save(resturant resturant);
    public List<resturant> findByName(String resturantName);
}
