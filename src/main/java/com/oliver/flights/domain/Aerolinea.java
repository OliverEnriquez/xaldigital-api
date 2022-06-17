package com.oliver.flights.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Aerolinea {

    @Id
    @Column(name = "id_aerolinea", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAerolinea;

    private String nombreAerolinea;

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "idVuelo", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Vuelo> vuelo;
}
