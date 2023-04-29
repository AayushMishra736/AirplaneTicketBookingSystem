package com.flight.booking.system.controller;


import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.service.Userdetailsservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Userdetailscontroller {

    @Autowired
    private Userdetailsservice usersetailsservice;

    @PostMapping("/save")
    public String createUser(@Valid @RequestBody Userdetails userdetails) {
        usersetailsservice.createUser(userdetails);
        return "User Created Succesfully";
    }

    @PutMapping("/update")
    public String updateUser(Userdetails userdetails) {
        usersetailsservice.updateUser(userdetails);
        return "User Data Updated Succesfully";
    }

    @DeleteMapping("/id/{userdetails}")
    public String deleteUser(@PathVariable long userdetails) {
        usersetailsservice.deleteUser(userdetails);
        return "User deleted Succesfully";
    }

    @GetMapping("/name/{userdetails}")
    public List<Userdetails> userByName(@PathVariable String userdetails) {
        return usersetailsservice.userByName(userdetails);
    }
}
