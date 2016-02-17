package com.abuchan.ukr.repo;

import com.abuchan.ukr.domain.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Overlord on 17.02.2016.
 */
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
