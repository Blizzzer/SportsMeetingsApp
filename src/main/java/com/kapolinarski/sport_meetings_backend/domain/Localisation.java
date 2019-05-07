package com.kapolinarski.sport_meetings_backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="localisation")
@Data
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "center_id")
    private LocalisationPoint center;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "localisation_id")
    private List<LocalisationPoint> polygonPoints = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "localisation_id")
    private List<SportType> sportTypes = new ArrayList<>();
}
