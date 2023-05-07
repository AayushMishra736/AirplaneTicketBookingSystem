package com.flight.booking.system.controller;


import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.service.Userdetailsservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api
public class Userdetailscontroller {
    public static final Logger logger = LoggerFactory.getLogger(Userdetailscontroller.class);
    @Autowired
    private Userdetailsservice usersetailsservice;

    @PostMapping("/save")
    @ApiOperation(value = "This is to create user.")
    public String createUser(@RequestBody Userdetails userdetails) {
        logger.info("Start creating user!!");
        usersetailsservice.createUser(userdetails);
        logger.info("User Created Successfully!!");
        return "User Created Succesfully";
    }

    @PutMapping("/update")
    @ApiOperation(value = "This is to update user.")
    public String updateUser(Userdetails userdetails) {
        logger.info("Updating the user!!.");
        usersetailsservice.updateUser(userdetails);
        logger.info("User updated successfully!!");
        return "User Data Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "This is to delete user data.")
    public String deleteUser(@PathVariable int id) {
        logger.info("Start deleting the user!!");
        usersetailsservice.deleteUser(id);
        logger.info("User Deleted Successfully!!");
        return "User Deleted Successfully!!";
    }

    @GetMapping("/name/{firstName}")
    @ApiOperation(value = "This is to search user by names.")
    public List<Userdetails> userByfirstName(@PathVariable String firstName) {
        logger.info("Start finding the user!!");
        List<Userdetails> userData = new ArrayList<>();
        userData = usersetailsservice.findByfirstName(firstName);
        logger.info("User Data Published Successfully!!");
        return userData;
    }
}
