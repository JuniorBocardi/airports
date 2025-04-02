package local.antonio.airports.controller;

import java.util.List;
import local.antonio.airports.DTO.AirportMinDTO;
import local.antonio.airports.DTO.AirportsNearMeDTO;
import local.antonio.airports.entities.Airport;
import local.antonio.airports.services.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {
            // Lista vazia, retornando 404
            return ResponseEntity.notFound().build();
        } else {
            // Dados encontrados, retornando 200
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);

        if (result.isEmpty()) {
            // Lista vazia, retornando 404
            return ResponseEntity.notFound().build();
        } else {
            // Dados encontrados, retornando 200
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {
            // Não encontrado, retornando 404
            return ResponseEntity.notFound().build();
        } else {
            // Dados encontrados, retornando 200
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/nearme")
    public ResponseEntity<List<AirportsNearMeDTO>> findNearMe(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        List<AirportsNearMeDTO> result = airportService.findNearMe(latitude, longitude);

        if (result.isEmpty()) {
            // Lista vazia, retornando 404
            return ResponseEntity.notFound().build();
        } else {
            // Dados encontrados, retornando 200
            return ResponseEntity.ok(result);
        }
    }
}
