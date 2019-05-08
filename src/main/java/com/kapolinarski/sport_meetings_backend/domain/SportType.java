package com.kapolinarski.sport_meetings_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="localisation_to_sport_type")
public class SportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sportType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;
}
