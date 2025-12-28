package com.fitness.user_service.repositories;

import com.fitness.user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByEmail(String email);
}
