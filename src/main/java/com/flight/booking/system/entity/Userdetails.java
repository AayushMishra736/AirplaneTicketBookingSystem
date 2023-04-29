package com.flight.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Data
@Document(collection = "Userdetails")
public class Userdetails {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date dateOfBirth;
    private int isTicketingAgent;
    private int isPassenger;
    private int isAdmin;
    private int isActive;
}
