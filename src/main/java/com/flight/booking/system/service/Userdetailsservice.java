package com.flight.booking.system.service;


import com.flight.booking.system.entity.Userdetails;
import org.springframework.stereotype.Service;

@Service
public interface Userdetailsservice {
    public void createUser(Userdetails userdetails);
    public void updateUser(Userdetails userdetails);
    public void deleteUser(Userdetails userdetails);
    public void userByName(String userdetails);
}
