package com.abuchan.ukr.service.impl;

import com.abuchan.ukr.domain.Citizen;
import com.abuchan.ukr.repo.CitizenRepository;
import com.abuchan.ukr.service.CitizenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ******* on 17.02.2016.
 */
@Service
@Transactional
public class CitizenServiceImpl implements CitizenService {


    private final Logger log = LoggerFactory.getLogger(CitizenServiceImpl.class);

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen save(Citizen citizen) {
        log.debug("Invocation save method with parameter : {}", citizen);
        Citizen result = citizenRepository.save(citizen);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Citizen> findAll() {
        log.debug("Invocation getAll method");
        List<Citizen> result = citizenRepository.findAll();
        return result;
    }

    @Transactional(readOnly = true)
    public Citizen findOne(Long id) {
        log.debug("Invocation get method with parameter : {}", id);
        Citizen citizen = citizenRepository.findOne(id);
        return citizen;
    }

    public void delete(Long id) {
        log.debug("Invocation delete method with parameter : {}", id);
        citizenRepository.delete(id);
    }
}
