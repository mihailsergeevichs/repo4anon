package com.abuchan.ukr.web.rest;

import com.abuchan.ukr.domain.Citizen;
import com.abuchan.ukr.service.CitizenService;
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
 * Created by ******* on 17.02.2016.
 */
@RestController
@RequestMapping("/api")
public class CitizenController {

    private final Logger log = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CitizenService citizenService;

    /*
    * POST method - creating new citizen
     */
    @RequestMapping(value = "citizens", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Citizen> addNewCitizen(@Valid @RequestBody Citizen citizen) throws URISyntaxException {
        log.debug("REST request to add new citizen {}", citizen);
        if (citizen.getId() != null) {
            return new ResponseEntity(citizen, HttpStatus.BAD_REQUEST);
        }
        Citizen persisted = citizenService.save(citizen);
        return new ResponseEntity<Citizen>(citizen, HttpStatus.OK);
    }

    /*
    * GET method - return all citizens
     */
    @RequestMapping(value = "citizens", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Citizen> getAllCitizens(){
        log.debug("REST request to get a list of citizens");
        List<Citizen> citizens = citizenService.findAll();
        return citizens;
    }

    /*
    * GET method - return citizen with id
    * @param city id
     */
    @RequestMapping(value = "/citizens/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Citizen> getCitizen(@PathVariable Long id) {
        log.debug("REST request to get citizen with id : {}", id);
        Citizen citizen = citizenService.findOne(id);
        if(citizen == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Citizen>(citizen, HttpStatus.OK);
    }

    /**
     * DELETE request to delete entity with id
     */
    @RequestMapping(value = "/citizen/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCitizen(@PathVariable Long id) {
        log.debug("REST request to delete citizen : {}", id);
        citizenService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
