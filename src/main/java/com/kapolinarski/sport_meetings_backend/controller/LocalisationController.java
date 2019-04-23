package com.kapolinarski.sport_meetings_backend.controller;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.domain.LocalisationPoint;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationPointDTO;
import com.kapolinarski.sport_meetings_backend.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/localisation")
public class LocalisationController {
    @Autowired
    private LocalisationService service;

    @GetMapping("/mock")
    public LocalisationDTO getMockLocalisation() {
        return new LocalisationDTO() {{
            id = 1L;
            name = "Gunwo";
            description = "Dobre gunwo";
            center = new LocalisationPointDTO() {{
                id = 1L;
                name = null;
                latitude = 57.2;
                longitude = 32.74;
            }};
            polygonPoints = new ArrayList<LocalisationPointDTO>() {{
                add(new LocalisationPointDTO() {{
                        id = 2L;
                        name = null;
                        latitude = 67.2;
                        longitude = 22.74;
                    }}
                );
                add(new LocalisationPointDTO() {{
                        id = 3L;
                        name = null;
                        latitude = 77.2;
                        longitude = 12.74;
                    }}
                );
                add(new LocalisationPointDTO() {{
                        id = 4L;
                        name = null;
                        latitude = -17.2;
                        longitude = -6.74;
                    }}
                );
            }};
        }};
    }

    @GetMapping("/{id}")
    public LocalisationDTO getSingleLocalisation(@PathVariable Long id) {
        Localisation localisation = service.getSingleLocalisation(id);
        return mapToLocalisationDTO(localisation);
    }

    private LocalisationDTO mapToLocalisationDTO(Localisation localisation) {
        LocalisationDTO localisationDTO = new LocalisationDTO();
        localisationDTO.name = localisation.getName();
        localisationDTO.description = localisation.getDescription();
        localisationDTO.id = localisation.getId();
        localisationDTO.center = mapToLocalisationPointDTO(localisation.getCenter());
        localisationDTO.polygonPoints = localisation.getPolygonPoints().stream().map(this::mapToLocalisationPointDTO).collect(toList());
        return localisationDTO;
    }

    private LocalisationPointDTO mapToLocalisationPointDTO(LocalisationPoint localisationPoint) {
        LocalisationPointDTO localisationPointDTO = new LocalisationPointDTO();
        localisationPointDTO.name = localisationPoint.getName();
        localisationPointDTO.id = localisationPoint.getId();
        localisationPointDTO.latitude = localisationPoint.getLatitude();
        localisationPointDTO.longitude = localisationPoint.getLongitude();
        return localisationPointDTO;
    }
}
