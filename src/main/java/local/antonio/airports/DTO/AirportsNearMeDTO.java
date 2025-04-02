/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.antonio.airports.DTO;

import local.antonio.airports.projections.AirportNearMeProjection;

/**
 *
 * @author sesideva
 */
public class AirportsNearMeDTO {
    
    private long id;
    private String name;
    private String city;
    private String iataCode;
    private double latitude;
    private double longitude;
    private double altitude;
    private double distanciaKM;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getIataCode() {
        return iataCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getDistanciaKM() {
        return distanciaKM;
    }

    public AirportsNearMeDTO(AirportNearMeProjection airportProjection) {
    this.id = airportProjection.getId();
    this.name = airportProjection.getName();
    this.city = airportProjection.getCity();
    this.iataCode = airportProjection.getIataCode();
    this.latitude = airportProjection.getLatitude();
    this.longitude = airportProjection.getLongitude();
    this.altitude = airportProjection.getAltitude();
    this.distanciaKM = airportProjection.getDistanciaKM();
    
    }
    public AirportsNearMeDTO() {
    }
}
