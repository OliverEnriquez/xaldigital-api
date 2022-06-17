package com.oliver.flights.service;

import com.oliver.flights.domain.Vuelo;
import com.oliver.flights.domain.VuelosDTO;
import com.oliver.flights.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VueloServiceimpl implements VueloService {

    @Autowired
    VueloRepository vueloRepository;

    @Override
    public List<VuelosDTO> findVuelos() {
        return vueloRepository.fetchVuelos();
    }

    @Override
    public String findAerolineaMorFlights() {
        List<VuelosDTO> vuelos = vueloRepository.fetchMoreAerolineaFlights();
        return vuelos.get(0).getAerolinea();
    }

    @Override
    public String findAeropuertoMoreMovimiento() {
        List<VuelosDTO> vuelos = vueloRepository.fetchMoreAropuertoMovimiento();
        return vuelos.get(0).getAeropuerto();
    }

    @Override
    public Date findMoreFlightsByDate() {
        List<VuelosDTO> vuelos = vueloRepository.fetchMoreAropuertoMovimiento();
        return vuelos.get(0).getDia();
    }

    @Override
    public List<String> findAerolineMoreThreeDays() {
        List<String> aeriolinea = vueloRepository.flightsMoreThreeDaysByDAy().stream().map(flight -> flight.getAerolinea()).collect(Collectors.toList());
        return aeriolinea;
    }
}
