package fr.univlittoral.dlabs.controllers;

import fr.univlittoral.dlabs.beans.Temperature;
import fr.univlittoral.dlabs.exceptions.TemperatureNotFoundException;
import fr.univlittoral.dlabs.services.TemperatureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/temperature")
public class TemperatureRestController {
    @Autowired
    private TemperatureService temperatureService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Temperature> getAllTemperature() {
        return temperatureService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Temperature getOneTemperature(@PathVariable Integer id){
        try{
            return temperatureService.findById(id);
        }catch(TemperatureNotFoundException e){
            return null;
        }
    }
}