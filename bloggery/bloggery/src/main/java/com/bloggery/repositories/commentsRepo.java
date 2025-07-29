package com.bloggery.repositories;

import com.bloggery.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentsRepo extends JpaRepository<Comments, Integer> {
    List<Comments> findByUserId(int userId);
    List<Comments> findByPostId(int postId);
}
