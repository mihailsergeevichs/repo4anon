package com.abuchan.ukr.service.impl;

import com.abuchan.ukr.domain.City;
import com.abuchan.ukr.repo.CityRepository;
import com.abuchan.ukr.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ****** on 17.02.2016.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        log.debug("Invocation save method with parameter : {}", city);
        City result = cityRepository.save(city);
        return result;
    }

    @Transactional(readOnly = true)
    public List<City> findAll() {
        log.debug("Invocation findAll method");
        List<City> result = cityRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public City findOne(Long id) {
        log.debug("Invocation findOne method with parameter : {}", id);
        City city = cityRepository.findOne(id);
        return city;
    }

    public void delete(Long id) {
        log.debug("Invocation delete method with parameter : {}", id);
        cityRepository.delete(id);
    }
}
