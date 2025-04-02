package local.antonio.airports.services;

import java.util.List;
import local.antonio.airports.DTO.AirportMinDTO;
import local.antonio.airports.DTO.AirportsNearMeDTO;
import local.antonio.airports.entities.Airport;
import local.antonio.airports.projections.AirportNearMeProjection;
import local.antonio.airports.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        // Retorna todos os aeroportos
        List<Airport> result = airportRepository.findAll();
        return result;
    }

    public List<Airport> findByCity(String city) {
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
    }
    
    public List<AirportMinDTO> findByCountry (String country) {
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
        
        List <AirportMinDTO> resultDTO = resultAirport.stream()
        .map (x -> new AirportMinDTO(x)).toList();
        
        return resultDTO;
    }
    
    public Airport findByIataCode (String iataCode) {
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
    }
    
    public List<AirportsNearMeDTO> findNearMe(double latitude, double longitude) {
        List< AirportNearMeProjection> resultNearAirports = airportRepository.findNearMe (latitude, longitude);
        
        List<AirportsNearMeDTO> resultDTO = resultNearAirports.stream()
                .map(x -> new AirportsNearMeDTO(x)).toList();
        
        return resultDTO;
}
    
}
