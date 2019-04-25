package com.kapolinarski.sport_meetings_backend.mapper;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.domain.SportType;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper
public abstract class LocalisationMapper {
    @Mapping(target = "sportTypes", expression = "java(mapSportTypeToString(localisation.getSportTypes()))")
    public abstract LocalisationDTO toLocalisationDTO(Localisation localisation);

    protected List<String> mapSportTypeToString(List<SportType> sportTypes) {
        return sportTypes.stream().map(SportType::getSportType).collect(toList());
    }
}
