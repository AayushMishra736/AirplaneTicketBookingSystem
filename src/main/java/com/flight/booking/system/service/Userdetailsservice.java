package com.flight.booking.system.service;


import com.flight.booking.system.entity.Userdetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Userdetailsservice {
    public void createUser(Userdetails userdetails);
    public void updateUser(Userdetails userdetails);
    public Userdetails deleteUser(long userdetails);
    public List<Userdetails> userByName(String userdetails);
}
