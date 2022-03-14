package fr.univlittoral.dlabs.controllers;

import fr.univlittoral.dlabs.beans.Deal;
import fr.univlittoral.dlabs.exceptions.DealNotFoundException;
import fr.univlittoral.dlabs.services.DealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/deal")
public class DealRestController {
    @Autowired
    private DealService dealService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Deal> getAllDeal() {
        return dealService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Deal getOneDeal(@PathVariable Integer id){
        try{
            return dealService.findById(id);
        }catch(DealNotFoundException e){
            return null;
        }
    }
}