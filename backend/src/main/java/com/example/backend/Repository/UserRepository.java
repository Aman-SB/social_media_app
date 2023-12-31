package com.example.backend.Repository;

import com.example.backend.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM User WHERE email = :email" , nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM User WHERE first_name LIKE %:query% OR last_name LIKE %:query% " , nativeQuery = true)
    List<User> searchUser(String query);
}
