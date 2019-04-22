package com.kapolinarski.sport_meetings_backend.dtos;


import java.util.List;

public class LocalisationDTO {
    public Long id;

    public String name;

    public String description;

    public LocalisationPointDTO center;

    public List<LocalisationPointDTO> polygonPoints;
}
