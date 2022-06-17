package com.oliver.flights.controller;

import com.oliver.flights.domain.VuelosDTO;
import com.oliver.flights.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class VueloController {

    @Autowired
    VueloService vueloService;

    @GetMapping("/vuelos")
    public List<VuelosDTO> findVuelos() {
        return vueloService.findVuelos();
    }

    @GetMapping("/aerolinea")
    public String findAerolineaMoreFlights() {
        return vueloService.findAerolineaMorFlights();
    }

    @GetMapping("/aeropuerto")
    public String findAeropuerto() {
        return vueloService.findAeropuertoMoreMovimiento();
    }

    @GetMapping("/dia")
    public Date findFlightsByDate() {
        return vueloService.findMoreFlightsByDate();
    }

    @GetMapping("/more/three")
    public List<String> findAerolineMoreThreeFlights() {
        return vueloService.findAerolineMoreThreeDays();
    }
}
