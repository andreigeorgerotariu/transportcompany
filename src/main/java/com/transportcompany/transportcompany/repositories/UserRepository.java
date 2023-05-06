package com.transportcompany.transportcompany.repositories;

import com.transportcompany.transportcompany.models.dtos.UserDTO;
import com.transportcompany.transportcompany.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
