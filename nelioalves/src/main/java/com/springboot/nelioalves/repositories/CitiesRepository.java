package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.CityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<CityEntity, Integer> {

}
