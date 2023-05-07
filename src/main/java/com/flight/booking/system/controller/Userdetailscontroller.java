package com.flight.booking.system.controller;


import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.service.Userdetailsservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api
public class Userdetailscontroller {

    @Autowired
    private Userdetailsservice usersetailsservice;

    @PostMapping("/save")
    @ApiOperation(value = "This is to create user.")
    public String createUser(@RequestBody Userdetails userdetails) {
        usersetailsservice.createUser(userdetails);
        return "User Created Succesfully";
    }

    @PutMapping("/update")
    @ApiOperation(value = "This is to update user.")
    public String updateUser(Userdetails userdetails) {
        usersetailsservice.updateUser(userdetails);
        return "User Data Updated Succesfully";
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "This is to delete user data.")
    public String deleteUser(@PathVariable int id) {
        usersetailsservice.deleteUser(id);
        return "User deleted Succesfully";
    }

    @GetMapping("/name/{firstName}")
    @ApiOperation(value = "This is to search user by names.")
    public List<Userdetails> userByfirstName(@PathVariable String firstName) {
        List<Userdetails> userData = new ArrayList<>();
        userData = usersetailsservice.findByfirstName(firstName);
        return userData;
    }
}
