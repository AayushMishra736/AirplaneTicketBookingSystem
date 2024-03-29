package com.flight.booking.system.serviceimpl;

import com.flight.booking.system.entity.Userdetails;
import com.flight.booking.system.repository.Userdetailsrepository;
import com.flight.booking.system.service.Userdetailsservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class Userdetailsserviceimpl implements Userdetailsservice {
    public static final Logger logger = LoggerFactory.getLogger(Userdetailsserviceimpl.class);
    @Autowired
    private Userdetailsrepository userdetailsrepository;
    @Autowired
    private Kafkaproducerimpl kakfaproducer;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void createUser(Userdetails userdetails) throws IOException, InterruptedException {
        logger.info("Inside create user service!!");
        userdetailsrepository.save(userdetails);
        //sendMessage("Inside create user service!!");
    }

    @Override
    public void updateUser(Userdetails userdetails) throws IOException, InterruptedException {
        logger.info("Inside update user service!!");
        userdetailsrepository.save(userdetails);
        //sendMessage("Inside update user service!!s");
    }

    @Override
    public Userdetails deleteUser(long userdetails) {
        logger.info("Inside delete user service!!");
        Optional<Userdetails> userdetails1 = userdetailsrepository.findById(userdetails);
        userdetails1.get().setIsActive(0);
        return userdetailsrepository.save(userdetails1.get());
    }

    @Override
    public List<Userdetails> findByfirstName(String userdetails) {
        logger.info("Inside getting details of user service!!");
        return userdetailsrepository.findByFirstNameAndIsActive(userdetails, 1);
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("myTopic", msg);
    }
}
