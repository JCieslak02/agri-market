package com.jcieslak.agrimarket.repository;

import com.jcieslak.agrimarket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);
}
