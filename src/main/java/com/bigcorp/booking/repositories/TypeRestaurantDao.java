package com.bigcorp.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bigcorp.booking.models.TypeRestaurant;

@Repository
public interface TypeRestaurantDao extends JpaRepository<TypeRestaurant, Integer> {

}
