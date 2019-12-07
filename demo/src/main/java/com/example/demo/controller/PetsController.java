package com.example.demo.controller;

import com.example.demo.models.Pets;
import com.example.demo.repositories.PetsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

	@RestController
	@RequestMapping("/pets")
	
	@Api(value="PETS", description="Operations pertaining to pets in pets record")
	public class PetsController {
	  @Autowired
	  private PetsRepository repository;
	  
	  private static final Logger LOGGER = LogManager.getLogger(PetsController.class.getName());
	     
	  
	  @ApiOperation(value = "Get all pets")
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	 
	  public List<Pets> getAllPets() {
		  LOGGER.info( "Fetched all");
	    return repository.findAll();
	  }
	  @ApiOperation(value = "Get pets based on ID")
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  
	  public Pets getPetById(@PathVariable("id") ObjectId id) {
		  LOGGER.info("Fetch pets based on specific id={}" ,id);
	    return repository.findBy_id(id);
	  }
	  @ApiOperation(value = "set ID")
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  
	  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
	    pets.set_id(id);
	   
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  
	  public Pets createPet(@Valid @RequestBody Pets pets) {
	    pets.set_id(ObjectId.get());
	    repository.save(pets);
	    return pets;
	  }
	  @ApiOperation(value = "Delete pets based on ID")
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  
	  public void deletePet(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }
	}

