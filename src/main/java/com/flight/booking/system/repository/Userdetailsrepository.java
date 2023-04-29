package com.flight.booking.system.repository;

import com.flight.booking.system.entity.Userdetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Userdetailsrepository extends MongoRepository<Userdetails, Long> {
    List<Userdetails> findByFirstName(String userdetails);
}
