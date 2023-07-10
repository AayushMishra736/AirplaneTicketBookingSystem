package com.flight.booking.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Userdetails")
@ApiModel(description = "Post model information")
public class Userdetails {

    @Id
    @ApiModelProperty(value = "User id")
    private long id;
    @ApiModelProperty(value = "User firstName")
    private String firstName;
    @ApiModelProperty(value = "User lastName")
    private String lastName;
    @ApiModelProperty(value = "User dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date dateOfBirth;
    @ApiModelProperty(value = "User is ticket admin")
    private int isTicketingAgent;
    @ApiModelProperty(value = "User is passenger")
    private int isPassenger;
    @ApiModelProperty(value = "User is admin")
    private int isAdmin;
    @ApiModelProperty(value = "User is active")
    private int isActive;
    @ApiModelProperty(value = "User Status")
    private String message;

}
