package com.abuchan.ukr.service;

import com.abuchan.ukr.domain.City;

import java.util.List;

/**
 * Created by ****** on 17.02.2016.
 */
public interface CityService {

    /**
     * Save existing city.
     * @return the persisted entity
     */
    public City save(City city);

    /**
     *  get all the cities.
     *  @return list of entities
     */
    public List<City> findAll();

    /**
     *  get the "id" city.
     *  @return corresponding entity
     */
    public City findOne(Long id);

    /**
     *  delete the "id" city.
     */
    public void delete(Long id);
}
