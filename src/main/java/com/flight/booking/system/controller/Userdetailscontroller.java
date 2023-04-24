package com.flight.booking.system.controller;


import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.service.Userdetailsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class Userdetailscontroller {

    @Autowired
    private Userdetailsservice usersetailsservice;

    @PostMapping("/save")
    public String createUser(@RequestBody Userdetails userdetails){
        usersetailsservice.createUser(userdetails);
        return "User Created Succesfully";
    }

    @PutMapping("/update")
    public String updateUser(Userdetails userdetails){
        usersetailsservice.updateUser(userdetails);
        return "User Data Updated Succesfully";
    }

    @DeleteMapping("/id")
    public String deleteUser(Userdetails userdetails){
        usersetailsservice.deleteUser(userdetails);
        return "User deleted Succesfully";
    }

    @GetMapping("/name/{userdetails}")
    public String userByName(String userdetails){
        usersetailsservice.userByName(userdetails);
        return "User deleted Succesfully";
    }


}
