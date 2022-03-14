package fr.univlittoral.dlabs.controllers;

import fr.univlittoral.dlabs.beans.User;
import fr.univlittoral.dlabs.exceptions.UserNotFoundException;
import fr.univlittoral.dlabs.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody User getOneUser(@PathVariable Integer id){
        try{
            return userService.findById(id);
        }catch(UserNotFoundException e){
            return null;
        }
    }
}