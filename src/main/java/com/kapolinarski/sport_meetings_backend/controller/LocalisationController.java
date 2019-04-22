package com.kapolinarski.sport_meetings_backend.controller;

import com.kapolinarski.sport_meetings_backend.dtos.LocalisationDTO;
import com.kapolinarski.sport_meetings_backend.dtos.LocalisationPointDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/localisation")
public class LocalisationController {
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
}
