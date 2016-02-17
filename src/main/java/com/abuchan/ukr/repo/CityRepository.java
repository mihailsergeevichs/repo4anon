package com.abuchan.ukr.repo;

import com.abuchan.ukr.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Overlord on 17.02.2016.
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
