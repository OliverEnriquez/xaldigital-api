package com.oliver.flights.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Vuelo {

    @Id
    @Column(name = "id_vuelo", nullable = false)
    Long idVuelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_aerolinea",referencedColumnName="id_aerolinea", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Aerolinea aerolinea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_aeropuerto",referencedColumnName="id_aeropuerto", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Aeropuerto aeropuerto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_movimiento",referencedColumnName="id_movimiento", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Movimiento movimiento;

    private Date dia;

}
