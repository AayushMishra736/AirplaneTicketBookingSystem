package com.flight.booking.system.serviceimpl;

import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.repository.Userdetailsrepository;
import com.flight.booking.system.service.Userdetailsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public Userdetails deleteUser(long userdetails) {
        Optional<Userdetails> userdetails1 = userdetailsrepository.findById(userdetails);
        userdetails1.get().setIsActive(0);
        return userdetailsrepository.save(userdetails1.get());
    }

    @Override
    public List<Userdetails> findByfirstName(String userdetails) {
        return userdetailsrepository.findByFirstNameAndIsActive(userdetails, 1);
    }
}
