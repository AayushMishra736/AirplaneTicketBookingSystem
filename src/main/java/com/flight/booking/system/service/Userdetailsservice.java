package com.flight.booking.system.service;


import com.flight.booking.system.entity.Userdetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface Userdetailsservice {
    public void createUser(Userdetails userdetails) throws IOException, InterruptedException;

    public void updateUser(Userdetails userdetails) throws IOException, InterruptedException;

    public Userdetails deleteUser(long userdetails);

    public List<Userdetails> findByfirstName(String userdetails);
}
