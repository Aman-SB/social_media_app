package com.example.backend.Repository;

import com.example.backend.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findByUserUserIdAndId(int userId, int postId);
}
