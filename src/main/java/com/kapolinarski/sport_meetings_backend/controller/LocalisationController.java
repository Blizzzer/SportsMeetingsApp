package com.kapolinarski.sport_meetings_backend.controller;

import com.kapolinarski.sport_meetings_backend.domain.Localisation;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationPointDTO;
import com.kapolinarski.sport_meetings_backend.mapper.LocalisationMapper;
import com.kapolinarski.sport_meetings_backend.service.LocalisationService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/localisation")
public class LocalisationController {
    @Autowired
    private LocalisationService service;

    private LocalisationMapper mapper = Mappers.getMapper(LocalisationMapper.class);

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
        return mapper.toLocalisationDTO(localisation);
    }
}
