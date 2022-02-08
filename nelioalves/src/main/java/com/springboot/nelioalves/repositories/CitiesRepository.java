package com.springboot.nelioalves.repositories;

import java.util.List;

import com.springboot.nelioalves.entities.CityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CitiesRepository extends JpaRepository<CityEntity, Integer> {

  @Transactional(readOnly = true)
  @Query("SELECT obj FROM city obj WHERE obj.state.id = :stateId ORDER BY obj.name")
  public List<CityEntity> findCityByStateId(@Param("stateId") Integer state_id);
}
