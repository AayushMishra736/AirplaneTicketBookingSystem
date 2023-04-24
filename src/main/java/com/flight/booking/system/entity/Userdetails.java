package com.flight.booking.system.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Userdetails")
public class Userdetails {

    @Id
    private long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "date_Of_Birth")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Timestamp dateOfBirth;
    @Column(name = "is_Ticketing_Agent")
    private int isTicketingAgent;
    @Column(name = "is_Passenger")
    private int isPassenger;
    @Column(name = "is_Admin")
    private int isAdmin;
    @Column(name = "is_Active")
    private int isActive;
}
