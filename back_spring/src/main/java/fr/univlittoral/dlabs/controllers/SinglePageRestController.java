package fr.univlittoral.dlabs.controllers;

import fr.univlittoral.dlabs.beans.Deal;
import fr.univlittoral.dlabs.beans.SinglePageDTO;
import fr.univlittoral.dlabs.services.SinglePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/singlepage")
public class SinglePageRestController {
    @Autowired
    private SinglePageService singlePageService;

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<SinglePageDTO> getAllSinglePageDTO() {
        return singlePageService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    SinglePageDTO getOneSinglePageDTO(@PathVariable Integer id){
        return singlePageService.findById(id);
    }

    @PostMapping(path="/add")
    public Deal addNewDeal(@RequestBody SinglePageDTO newSinglePageDTO) {
        return singlePageService.saveOne(newSinglePageDTO);
    }
}
