package com.springboot.nelioalves.services;

import java.util.List;

import com.springboot.nelioalves.entities.CityEntity;
import com.springboot.nelioalves.repositories.CitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {

  @Autowired
  CitiesRepository citiesRepository;

  public List<CityEntity> findCityByStateId(Integer stateId) {
    return citiesRepository.findCityByStateId(stateId);
  }

}
