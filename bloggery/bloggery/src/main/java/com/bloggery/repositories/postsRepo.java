package com.bloggery.repositories;

import com.bloggery.entities.Posts;
import com.bloggery.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface postsRepo extends JpaRepository<Posts, Integer> {
    public List<Posts> findByUserId(int userId);
    public List<Posts> findByState (Posts.postState state);
    public List<Posts> findByTagIds (Tags tag);
}
