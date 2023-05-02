package com.transportcompany.transportcompany.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private long id;
    private String name;
    private String address;
    private String email;

}
