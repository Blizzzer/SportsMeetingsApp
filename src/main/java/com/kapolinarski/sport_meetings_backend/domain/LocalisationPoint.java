package com.kapolinarski.sport_meetings_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="localisation_point")
@Data
public class LocalisationPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double latitude;

    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;
}
