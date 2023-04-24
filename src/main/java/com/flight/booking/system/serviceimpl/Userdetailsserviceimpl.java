package com.flight.booking.system.serviceimpl;

import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.repository.Userdetailsrepository;
import com.flight.booking.system.service.Userdetailsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userdetailsserviceimpl implements Userdetailsservice {

    @Autowired
    private Userdetailsrepository userdetailsrepository;

    @Override
    public void createUser(Userdetails userdetails) {
        userdetailsrepository.save(userdetails);
    }

    @Override
    public void updateUser(Userdetails userdetails) {
        userdetailsrepository.save(userdetails);
    }

    @Override
    public void deleteUser(Userdetails userdetails) {
        userdetailsrepository.save(userdetails);
    }

    @Override
    public void userByName(String userdetails) {
       userdetailsrepository.findByName(userdetails);
    }
}
