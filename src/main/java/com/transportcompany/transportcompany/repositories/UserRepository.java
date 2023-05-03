package com.transportcompany.transportcompany.repositories;
import com.transportcompany.transportcompany.models.dtos.UserDTO;
import com.transportcompany.transportcompany.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    static User save(UserDTO userToSave) {
        return null;
    }
}
