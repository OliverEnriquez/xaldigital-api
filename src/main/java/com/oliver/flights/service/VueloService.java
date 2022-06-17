package com.oliver.flights.service;

import com.oliver.flights.domain.VuelosDTO;

import java.util.Date;
import java.util.List;

public interface VueloService {
    List<VuelosDTO> findVuelos();

    String findAerolineaMorFlights();

    String findAeropuertoMoreMovimiento();

    Date findMoreFlightsByDate();

    List<String> findAerolineMoreThreeDays();
}
