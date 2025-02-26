/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.antonio.airports.controller;

import java.util.List;
import local.antonio.airports.entities.Airport;
import local.antonio.airports.services.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class AirportController {
    
  
        
        @Autowired
        private AirportService airportService;
        
       @GetMapping("/airport")
       public List<Airport> findAll() {
           List<Airport> result = airportService.findAll();
           return result;
       }
      
      
    }
   
