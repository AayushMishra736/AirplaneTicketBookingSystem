package com.flight.booking.system.repository;

import com.flight.booking.system.entity.Userdetails;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Userdetailsrepository extends ListCrudRepository<Userdetails, Long> {
    List<Userdetails> findByFirstNameAndIsActive(String userdetails, int value);
}
