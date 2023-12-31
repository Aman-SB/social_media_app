package com.example.backend.Repository;

import com.example.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "Select * FROM User" , nativeQuery = true)
    List<User> findAll();

    User findByEmail(String email);

    @Query(value = "SELECT * FROM User WHERE first_name LIKE %:query% OR last_name LIKE %:query% " , nativeQuery = true)
    List<User> searchUser(String query);
}
