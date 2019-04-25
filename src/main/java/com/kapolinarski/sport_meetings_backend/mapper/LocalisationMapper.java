package com.kapolinarski.sport_meetings_backend.mapper;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LocalisationMapper {
    @Mapping(target = "center", ignore = true)
    @Mapping(target = "polygonPoints", ignore = true)
    @Mapping(target = "sportTypes", ignore = true)
    LocalisationDTO toLocalisationDTO(Localisation localisation);
}
