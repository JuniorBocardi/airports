/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.antonio.airports.controller;

import java.util.List;
import local.antonio.airports.DTO.AirportMinDTO;
import local.antonio.airports.entities.Airport;
import local.antonio.airports.services.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AirportController {
    
  
        
        @Autowired
        private AirportService airportService;
        
       @GetMapping("/airport")
       public List<Airport> findAll() {
           List<Airport> result = airportService.findAll();
           return result;
       }
           
       @GetMapping ("/city/{cityName}")
       public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
           List<Airport> result = airportService.findByCity(cityName);
           
           if (result.isEmpty()) {
               //Ops..lista vazia...
               //notFound devolve404
               return ResponseEntity.notFound().build();
               
           }else {
               //Tem dados
               return ResponseEntity.ok(result);
           }
       }
       
       @GetMapping("/country/{countryName}")
        public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);
        
        if (result.isEmpty()) {
        // Ops.. lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
        } else {
        // Eba! Tem dados!
        // ok devolve 200
        return  ResponseEntity.ok(result);
    }
}
      @GetMapping ("/iatacode/{iataCode}")
      public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
          Airport result = airportService.findByIataCode(iataCode);
          
           if (result == null) {
        // Ops.. lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
        } else {
        // Eba! Tem dados!
        // ok devolve 200
        return  ResponseEntity.ok(result);
    }
   }
}
      
     
   
