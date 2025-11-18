package com.bloggery.repositories;

import com.bloggery.entities.Posts;
import com.bloggery.entities.Tags;
import com.bloggery.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postsRepo extends JpaRepository<Posts, Integer> {
    public List<Posts> findByUserId(Users userId);
    public List<Posts> findByState (Posts.postState state);
    public List<Posts> findByTagIDs (Tags tag);
}
