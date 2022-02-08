package com.springboot.nelioalves.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.nelioalves.dto.CityDTO;
import com.springboot.nelioalves.dto.StateDTO;
import com.springboot.nelioalves.entities.CityEntity;
import com.springboot.nelioalves.entities.StateEntity;
import com.springboot.nelioalves.services.CitiesService;
import com.springboot.nelioalves.services.StatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/states")
public class StatesResources {

  @Autowired
  StatesService statesService;

  @Autowired
  CitiesService citiesService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<StateDTO>> findAll() {
    List<StateEntity> objects = statesService.findAll();
    List<StateDTO> objectsDTO = objects.stream().map(object -> new StateDTO(object))
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(objectsDTO);
  }

  @RequestMapping(value = "/{stateId}/cities", method = RequestMethod.GET)
  public ResponseEntity<List<CityDTO>> findCities(@PathVariable Integer stateId) {
    List<CityEntity> list = citiesService.findCityByStateId(stateId);
    List<CityDTO> objectsDTO = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(objectsDTO);
  }
}
