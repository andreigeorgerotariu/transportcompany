package com.transportcompany.transportcompany.services;

import com.transportcompany.transportcompany.models.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO updateClient(UserDTO userDTO);
    List<UserDTO> getAllUsers();

    List<UserDTO> getUsers();
}
