package com.kapolinarski.sport_meetings_backend.service;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.exception.ResourceNotFoundException;
import com.kapolinarski.sport_meetings_backend.repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LocalisationService {
    @Autowired
    private LocalisationRepository repository;

    public Localisation getSingleLocalisation(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Localisation", "id", id));
    }

    @Transactional
    public Localisation saveLocalisation(Localisation localisation) {
        return repository.save(localisation);
    }

    @Transactional
    public void deleteLocalisation(Long id) {
        repository.deleteById(id);
    }
}
