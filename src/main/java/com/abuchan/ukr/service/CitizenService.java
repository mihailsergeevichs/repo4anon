package com.abuchan.ukr.service;

import com.abuchan.ukr.domain.Citizen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ********* on 17.02.2016.
 */
public interface CitizenService {

    /**
     * Save a citizen.
     * @param citizen - instance to persisting
     * @return the persisted entity
     */
    public Citizen save(Citizen citizen);

    /**
     *  get all the citizens.
     *  @return list of citizen entities
     */
    public List<Citizen> findAll();

    /**
     *  getting entity with id
     *  @param id - id of existing entity
     *  @return citizen entity
     */
    public Citizen findOne(Long id);

    /**
     *  delete citizen with id.
     *  @param id
     */
    public void delete(Long id);
}
