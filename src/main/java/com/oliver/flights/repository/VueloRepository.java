package com.oliver.flights.repository;

import com.oliver.flights.domain.Vuelo;
import com.oliver.flights.domain.VuelosDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.*;

@Repository
public interface VueloRepository extends CrudRepository<Vuelo, Long> {


    @Query(" SELECT new com.oliver.flights.domain.VuelosDTO(ar.nombreAerolinea, ap.nombreAeropuerto, m.descripcion, v.dia) "
            + "FROM Vuelo v Inner JOIN v.aerolinea ar Inner JOIN v.aeropuerto ap  Inner JOIN v.movimiento m ")
    List<VuelosDTO> fetchVuelos();

    @Query(" SELECT new com.oliver.flights.domain.VuelosDTO(ar.nombreAerolinea, ap.nombreAeropuerto, m.descripcion, v.dia) "
            + "FROM Vuelo v Inner JOIN v.aerolinea ar Inner JOIN v.aeropuerto ap  Inner JOIN v.movimiento m "
            + " GROUP BY ar.nombreAerolinea"
            + " ORDER BY COUNT(ar.nombreAerolinea) DESC")
    List<VuelosDTO> fetchMoreAerolineaFlights();

    @Query(" SELECT new com.oliver.flights.domain.VuelosDTO(ar.nombreAerolinea, ap.nombreAeropuerto, m.descripcion, v.dia) "
            + "FROM Vuelo v Inner JOIN v.aerolinea ar Inner JOIN v.aeropuerto ap  Inner JOIN v.movimiento m "
            + " GROUP BY ap.nombreAeropuerto"
            + " ORDER BY COUNT(v.movimiento) DESC")
    List<VuelosDTO> fetchMoreAropuertoMovimiento();

    @Query(" SELECT new com.oliver.flights.domain.VuelosDTO(ar.nombreAerolinea, ap.nombreAeropuerto, m.descripcion, v.dia) "
            + "FROM Vuelo v Inner JOIN v.aerolinea ar Inner JOIN v.aeropuerto ap  Inner JOIN v.movimiento m "
            + " GROUP BY v.dia"
            + " ORDER BY COUNT(v.idVuelo) DESC")
    List<VuelosDTO> fetchMoreFLightsByDate();

    @Query(" SELECT new com.oliver.flights.domain.VuelosDTO(ar.nombreAerolinea, ap.nombreAeropuerto, m.descripcion, v.dia) "
            + "FROM Vuelo v Inner JOIN v.aerolinea ar Inner JOIN v.aeropuerto ap  Inner JOIN v.movimiento m "
            + " GROUP BY v.dia, v.aerolinea"
            + " HAVING count( v.dia) >= 3")
    List<VuelosDTO> flightsMoreThreeDaysByDAy();

}
