package com.transportcompany.transportcompany.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String name;
    private String address;
    private String email;
    private long id;
}
