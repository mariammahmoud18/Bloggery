package com.bloggery.repositories;

import com.bloggery.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface commentsRepo extends JpaRepository<Comments, Integer> {
    List<Comments> findByUserId(int userId);
    List<Comments> findByPostId(int postId);
}
