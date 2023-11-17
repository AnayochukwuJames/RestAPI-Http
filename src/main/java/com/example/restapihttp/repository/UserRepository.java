package com.example.restapihttp.repository;

import com.example.restapihttp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

}
