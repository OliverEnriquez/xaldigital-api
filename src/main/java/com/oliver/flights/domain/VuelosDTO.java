package com.oliver.flights.domain;

import java.util.Date;

public class VuelosDTO {
    String aerolinea;
    String aeropuerto;
    String movimiento;
    Date dia;

    public VuelosDTO(String aerolinea, String aeropuerto, String movimiento, Date dia) {
        this.aerolinea = aerolinea;
        this.aeropuerto = aeropuerto;
        this.movimiento = movimiento;
        this.dia = dia;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
}
