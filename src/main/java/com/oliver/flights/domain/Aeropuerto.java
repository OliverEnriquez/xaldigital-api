package com.oliver.flights.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Aeropuerto {

    @Id
    @Column(name = "id_aeropuerto", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAeropuerto;
    private String nombreAeropuerto;

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "aeropuerto", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Vuelo> vuelo;
}
