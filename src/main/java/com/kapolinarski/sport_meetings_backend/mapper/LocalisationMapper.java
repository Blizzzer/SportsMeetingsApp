package com.kapolinarski.sport_meetings_backend.mapper;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LocalisationMapper {
    @Mapping(target = "sportTypes", expression = "java(localisation.getSportTypes().stream().map((type)-> type.getSportType()).collect(Collectors.toList()))")
    LocalisationDTO toLocalisationDTO(Localisation localisation);
}
