package com.kapolinarski.sport_meetings_backend.repository;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

}
