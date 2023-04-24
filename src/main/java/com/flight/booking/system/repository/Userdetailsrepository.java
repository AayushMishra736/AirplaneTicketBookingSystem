package com.flight.booking.system.repository;

import com.flight.booking.system.entity.Userdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Userdetailsrepository extends JpaRepository<Userdetails, Long> {
    List<Userdetails> findByName(String name);
}
