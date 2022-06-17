package com.oliver.flights.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Movimiento {
    @Id
    @Column(name = "id_movimiento", nullable = false)
    private Long idmovimiento;

    private String descripcion;

    @OneToMany(targetEntity = Vuelo.class, mappedBy = "movimiento", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Vuelo> vuelo;
}
