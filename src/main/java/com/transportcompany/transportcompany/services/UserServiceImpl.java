package com.transportcompany.transportcompany.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportcompany.transportcompany.exceptions.UserCreateException;
import com.transportcompany.transportcompany.exceptions.UserNotFoundException;
import com.transportcompany.transportcompany.models.dtos.UserDTO;
import com.transportcompany.transportcompany.models.entities.User;
import com.transportcompany.transportcompany.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {

        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (!userDTO.getEmail().contains("@")) {
            throw new UserCreateException("Invalid email format.");
        }
        User userToSave = objectMapper.convertValue(userDTO, User.class);
        User userSaved = (User) userRepository.save(userToSave);
        return objectMapper.convertValue(userSaved, UserDTO.class);
    }

    @Override
    public UserDTO updateUserById(long userId, UserDTO userDTO) {
        User userFound = (User) userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userFound.setName(userDTO.getName());
        userFound.setAddress(userDTO.getAddress());
        userFound.setEmail(userDTO.getEmail());
        User userSaved = (User) userRepository.save(userFound);
        return objectMapper.convertValue(userSaved, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> usersFound = userRepository.findAll();
        List<UserDTO> usersFoundDTO = new ArrayList<>();
        usersFound.forEach(user -> usersFoundDTO.add(objectMapper.convertValue(user, UserDTO.class)));
        return usersFoundDTO;
    }

    public void deleteUserById(long id) {

        userRepository.deleteById(id);
    }
}
