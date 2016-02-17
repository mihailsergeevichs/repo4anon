package com.abuchan.ukr.web.rest;

import com.abuchan.ukr.domain.City;
import com.abuchan.ukr.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by ****** on 17.02.2016.
 */
@RestController
@RequestMapping("/api")
public class CityController {

    private final Logger log = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    /*
    * POST method - creating new city
    * @param city
     */
    @RequestMapping(value = "cities", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> addNewCity(@Valid @RequestBody City city) throws URISyntaxException {
        log.debug("REST request to add new city {}", city);
        if (city.getId() != null) {
            return new ResponseEntity(city, HttpStatus.BAD_REQUEST);
        }
        City persisted = cityService.save(city);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    /*
    * GET method - return all cities
     */
    @RequestMapping(value = "cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCities(){
        log.debug("REST request to get a list of cities");
        List<City> cities = cityService.findAll();
        return cities;
    }

    /*
    * GET method - return city with id
    * @param city id
     */
    @RequestMapping(value = "/cities/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable Long id) {
        log.debug("REST request to get city with id : {}", id);
        City city = cityService.findOne(id);
        if(city == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    /**
     * DELETE request to delete entity with id
     * @param id
     */
    @RequestMapping(value = "/cities/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        log.debug("REST request to delete City : {}", id);
        cityService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
