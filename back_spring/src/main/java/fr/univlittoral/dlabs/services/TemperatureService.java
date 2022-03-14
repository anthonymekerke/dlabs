package fr.univlittoral.dlabs.services;

import fr.univlittoral.dlabs.beans.Temperature;
import fr.univlittoral.dlabs.exceptions.TemperatureNotFoundException;
import fr.univlittoral.dlabs.repositories.TemperatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;

    public Iterable<Temperature> findAll() { return temperatureRepository.findAll(); }

    public Temperature findById(Integer id) throws TemperatureNotFoundException {
        return temperatureRepository.findById(id).orElseThrow(()->
                new TemperatureNotFoundException(id)
        );
    }

    public Temperature saveOne(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }
}
