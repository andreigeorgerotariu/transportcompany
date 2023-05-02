package com.transportcompany.transportcompany.services;

import com.transportcompany.transportcompany.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUserById(long userId, UserDTO userDTO);

    void deleteUserById(long id);

    List<UserDTO> getUsers();


}
