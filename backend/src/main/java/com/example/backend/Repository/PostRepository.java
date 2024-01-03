package com.example.backend.Repository;

import com.example.backend.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value = "SELECT * FROM Post where user_user_id = :userId AND id = :postId",nativeQuery = true)
    Optional<Post> findByUserUserIdAndId(int postId, int userId);
}
